package com.techvista.assignment.Modules.main.fragment

import android.view.View
import android.widget.TextView
import com.techvista.assignment.R
import com.techvista.assignment.base.fragment.BaseFragment
import com.techvista.assignment.base.utils.key_body
import com.techvista.assignment.base.utils.key_title
import kotlinx.android.synthetic.main.fragment_post_detail.*

class PostDetailFragment : BaseFragment() {

    private lateinit var title: TextView
    private lateinit var body: TextView

    override val layoutId: Int = R.layout.fragment_post_detail

    override fun initializeViews(view: View) {
        title = tv_title
        body = tv_body

        getBundle()
    }

    override fun setListeners() {
    }

    override fun onClick(v: View?) {
    }

    fun getBundle() {
        val bundle = arguments
        if (bundle != null) {
            title.text = bundle.getString(key_title)
            body.text = bundle.getString(key_body)
        }
    }
}