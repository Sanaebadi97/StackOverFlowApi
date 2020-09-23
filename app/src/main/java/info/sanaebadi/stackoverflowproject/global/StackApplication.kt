package info.sanaebadi.stackoverflowproject.global

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import info.sanaebadi.stackoverflowproject.di.DaggerApplicationComponent
import javax.inject.Inject

class StackApplication  : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>


    override fun onCreate() {
        super.onCreate()
        initializeAppInjector()
    }

    private fun initializeAppInjector() {
        DaggerApplicationComponent.builder().application(this).build().inject(this)
    }


}