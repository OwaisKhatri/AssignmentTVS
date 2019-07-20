package com.techvista.assignment.base.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.techvista.assignment.Modules.main.viewmodel.MainVM
import com.techvista.assignment.base.di.components.DaggerViewModelInjector
import com.techvista.assignment.base.di.modules.NetworkModule

abstract class BaseViewModel(application: Application) : AndroidViewModel(application) {

    private val injector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    private fun inject() {
        when(this) {
            is MainVM -> injector.inject(this)
        }
    }
}