package info.sanaebadi.stackoverflowproject.di

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import info.sanaebadi.stackoverflowproject.global.StackApplication
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ApplicationModule::class, BuildersModule::class, ViewModelModule::class])

interface ApplicationComponent : AndroidInjector<StackApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: StackApplication): Builder

        fun build(): ApplicationComponent
    }
}