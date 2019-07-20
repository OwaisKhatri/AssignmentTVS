package com.techvista.assignment.Modules.main.activity

import android.view.View
import android.widget.LinearLayout
import com.techvista.assignment.Modules.main.fragment.PostsListFragment
import com.techvista.assignment.R
import com.techvista.assignment.base.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var progressBarLayout: LinearLayout

    override val layoutId = R.layout.activity_main

    override val containerId = R.id.main_frame_container

    override fun initializeView() {
        progressBarLayout = progressBar_layout

        changeFragment(PostsListFragment(), false)
    }

    override fun setListeners() {
         
    }

    override fun onClick(v: View?) {
         
    }

    override fun onLoadingStarted(message: String) {
         progressBarLayout.visibility = View.VISIBLE
    }

    override fun onLoadingFinished() {
        progressBarLayout.visibility = View.GONE
    }

    override fun onProgressUpdated(percentLoaded: Int) {
        
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val api = BaseHTTPClient.createAPI()
//        val list = api?.getPosts()
//            ?.subscribeOn(Schedulers.io())
//            ?.unsubscribeOn(Schedulers.computation())
//            ?.observeOn(AndroidSchedulers.mainThread())
//            ?.subscribe ({
//                var response = it
//                Log.d("size", it?.size.toString())
//            }, {
//                Log.d("failure", it.localizedMessage)
//            } )
//
//
//    }
}
