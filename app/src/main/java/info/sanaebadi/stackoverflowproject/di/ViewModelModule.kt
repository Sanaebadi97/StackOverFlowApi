package info.sanaebadi.stackoverflowproject.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import info.sanaebadi.stackoverflowproject.mvvm.feature.view.viewModel.base.ViewModelFactory
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: ViewModelFactory?): ViewModelProvider.Factory?


}