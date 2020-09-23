package info.sanaebadi.stackoverflowproject.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import info.sanaebadi.placeapp.global.PlaceApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, BuildersModule::class, ViewModelModule::class])

interface ApplicationComponent : AndroidInjector<PlaceApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: PlaceApplication): Builder

        fun build(): ApplicationComponent
    }
}