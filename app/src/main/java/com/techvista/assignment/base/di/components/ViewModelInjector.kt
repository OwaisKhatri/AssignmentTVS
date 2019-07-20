package com.techvista.assignment.base.di.components

import com.techvista.assignment.Modules.main.viewmodel.MainVM
import com.techvista.assignment.base.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(mainVM: MainVM)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}