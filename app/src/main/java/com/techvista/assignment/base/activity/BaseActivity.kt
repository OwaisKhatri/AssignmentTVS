package com.techvista.assignment.base.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.techvista.assignment.base.utils.LoadingListener

abstract class BaseActivity: AppCompatActivity(), View.OnClickListener, LoadingListener {

    abstract val layoutId: Int
    abstract val containerId: Int
    abstract fun initializeView()
    abstract fun setListeners()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        initializeView()
        setListeners()
    }

    fun changeFragment(fragment: Fragment, addToBackStack: Boolean = true, cleanBackStack: Boolean = false) {
        if (cleanBackStack) {
            clearBackStack()
        }
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(containerId, fragment)
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(null)
        }
        fragmentTransaction.commit()
    }

    fun clearBackStack() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 0) {
            val backStackEntry = fragmentManager.getBackStackEntryAt(0)
            fragmentManager.popBackStack(backStackEntry.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }
}