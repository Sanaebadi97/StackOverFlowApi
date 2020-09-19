
package info.sanaebadi.executor


import info.sanaebadi.domain.executor.ThreadExecutor
import javax.inject.Inject
import javax.inject.Singleton
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit


/**
 * Decorated [ThreadPoolExecutor]
 */
@Singleton
class JobExecutor @Inject
constructor() : ThreadExecutor {

    private val threadPoolExecutor: ThreadPoolExecutor

    init {
        this.threadPoolExecutor = ThreadPoolExecutor(
            5, 15, 15, TimeUnit.SECONDS,
            LinkedBlockingQueue(), JobThreadFactory()
        )


    }

    override fun execute(runnable: Runnable) {
        this.threadPoolExecutor.execute(runnable)
    }

    private inner class JobThreadFactory : ThreadFactory {
        private var counter = 0

        override fun newThread(runnable: Runnable): Thread {
            return Thread(runnable, "android_" + counter++)
        }
    }
}
