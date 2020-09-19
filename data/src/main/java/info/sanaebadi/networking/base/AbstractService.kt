package info.sanaebadi.networking.base

import info.sanaebadi.data.BuildConfig
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

abstract class AbstractService<S>(
    serviceType: Class<S>
) {
    internal var service: S
    private var serviceType: Class<S>? = serviceType

    init {
        service = createService(BuildConfig.API_BASE_URL)
    }


    fun setBaseUrl(baseUrl: String) {
        service = createService(baseUrl)
    }


    private fun createService(baseUrl: String): S {


        val client = OkHttpClient.Builder()
            .connectTimeout(TIME_OUT_MIL_SECS, TimeUnit.SECONDS)
            .build()
        val retrofitBuilder = Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        return retrofitBuilder.client(client).build().create(serviceType!!)
    }


    companion object {
        private const val TIME_OUT_MIL_SECS = 60L
    }
}