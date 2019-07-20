package com.techvista.assignment.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.techvista.assignment.Modules.main.viewmodel.MainVM
import com.techvista.assignment.base.activity.BaseActivity
import com.techvista.assignment.base.database.AppDatabase

class ViewModelFactory(private val activity: BaseActivity?): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainVM::class.java)) {
            val db = Room.databaseBuilder(activity!!.applicationContext, AppDatabase::class.java, "posts").build()
            @Suppress("UNCHECKED_CAST")
            return MainVM(activity!!.application, db.postItemDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}