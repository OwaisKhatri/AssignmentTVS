package com.techvista.assignment.base.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.techvista.assignment.Modules.main.activity.MainActivity

abstract class BaseFragment : Fragment(), View.OnClickListener {

    abstract val layoutId: Int

    val mainActivity: MainActivity?
        get() = activity as MainActivity?

    abstract fun initializeViews(view: View)

    abstract fun setListeners()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews(view)
        setListeners()
    }

}
