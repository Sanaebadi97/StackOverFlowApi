package info.sanaebadi.stackoverflowproject.di

import android.content.Context
import dagger.Module
import dagger.Provides
import info.sanaebadi.data.executor.JobExecutor
import info.sanaebadi.data.repository.dataSource.place.PlaceDataRepository
import info.sanaebadi.domain.executor.PostExecutionThread
import info.sanaebadi.domain.executor.ThreadExecutor
import info.sanaebadi.domain.repository.place.places.PlaceRepository
import info.sanaebadi.placeapp.executors.UIThread
import info.sanaebadi.placeapp.global.PlaceApplication
import info.sanaebadi.placeapp.util.AppSchedulerProvider
import info.sanaebadi.placeapp.util.ConnectionHelper
import info.sanaebadi.placeapp.util.PreferencesHelper
import info.sanaebadi.placeapp.util.SchedulerProvider
import javax.inject.Singleton

@Module
class ApplicationModule {

    //TODO:DEFINE REPOSITORY AND CACHE HERE

    @Provides
    internal fun provideContext(application: PlaceApplication): Context {
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
    fun providePlaceRepository(placeDataRepository: PlaceDataRepository): PlaceRepository {
        return placeDataRepository
    }


    @Provides
    @Singleton
    fun provideConnectionHelper(context: Context) = ConnectionHelper(context)

    @Provides
    @Singleton
    fun providePreferencesHelper(context: Context) = PreferencesHelper(context)



    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider = AppSchedulerProvider()

}