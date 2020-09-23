package info.sanaebadi.stackoverflowproject.di

import android.content.Context
import dagger.Module
import dagger.Provides
import info.sanaebadi.data.executor.JobExecutor
import info.sanaebadi.data.repository.dataSource.place.PlaceDataRepository
import info.sanaebadi.domain.executor.PostExecutionThread
import info.sanaebadi.domain.executor.ThreadExecutor
import info.sanaebadi.domain.repository.UserRepository
import info.sanaebadi.domain.repository.place.places.PlaceRepository
import info.sanaebadi.executor.JobExecutor
import info.sanaebadi.placeapp.executors.UIThread
import info.sanaebadi.placeapp.global.PlaceApplication
import info.sanaebadi.stackoverflowproject.util.AppSchedulerProvider
import info.sanaebadi.stackoverflowproject.util.SchedulerProvider
import info.sanaebadi.repository.dataSource.user.UserDataRepository
import info.sanaebadi.stackoverflowproject.executors.UIThread
import info.sanaebadi.stackoverflowproject.global.StackApplication
import javax.inject.Singleton

@Module
class ApplicationModule {

    //TODO:DEFINE REPOSITORY AND CACHE HERE

    @Provides
    internal fun provideContext(application: StackApplication): Context {
        return application.applicationContext
    }


    @Provides
    @Singleton
    internal fun providesThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    internal fun providesPostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @Singleton
    fun provideUserRepository(userDataRepository: UserDataRepository): UserRepository {
        return userDataRepository
    }


//    @Provides
//    @Singleton
//    fun provideConnectionHelper(context: Context) = ConnectionHelper(context)
//
//    @Provides
//    @Singleton
//    fun providePreferencesHelper(context: Context) = PreferencesHelper(context)


    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

}