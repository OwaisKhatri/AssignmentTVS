package com.techvista.assignment.Modules.main.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.techvista.assignment.Modules.main.adapter.PostsAdapter
import com.techvista.assignment.Modules.main.models.GetPostsResponse
import com.techvista.assignment.Modules.main.viewmodel.MainVM
import com.techvista.assignment.R
import com.techvista.assignment.base.fragment.BaseFragment
import com.techvista.assignment.base.utils.*
import com.techvista.assignment.base.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_posts_list.*

class PostsListFragment : BaseFragment(), SwipeRefreshLayout.OnRefreshListener, RVItemClickListener<GetPostsResponse> {

    private lateinit var swipeToRefresh: SwipeRefreshLayout

    private lateinit var rvPostsList: RecyclerView
    private lateinit var postsAdapter: PostsAdapter

    private lateinit var mainVM: MainVM

    override val layoutId = R.layout.fragment_posts_list

    override fun initializeViews(view: View) {
        swipeToRefresh = swipeLayout
        swipeToRefresh.setOnRefreshListener(this)

        rvPostsList = rv_postsList
        val postsLayoutManager = LinearLayoutManager(mainActivity?.applicationContext, RecyclerView.VERTICAL, false)
        postsAdapter = PostsAdapter();
        rvPostsList = rv_postsList.apply {
            setHasFixedSize(true)
            layoutManager = postsLayoutManager
            adapter = postsAdapter
        }

        mainVM = ViewModelProviders.of(this, ViewModelFactory(mainActivity!!)).get(MainVM::class.java)
        mainVM.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null)
                mainActivity?.applicationContext?.toast(getString(errorMessage))
        })
        mainVM.loader.observe(this, Observer { loaderVisibility ->
            swipeToRefresh.isRefreshing = false
            if (loaderVisibility == View.VISIBLE) {
                mainActivity?.onLoadingStarted(getString(R.string.please_wait))
            } else if (loaderVisibility == View.GONE) {
                mainActivity?.onLoadingFinished()
            }
        })

        mainVM.posts.observe(this, Observer { postsList ->
            postsAdapter.updateLists(postsList)
        })
    }

    override fun setListeners() {
        postsAdapter.setListeners(this)
    }

    override fun onClick(v: View?) {

    }

    override fun onRefresh() {
        mainVM.getPosts()
    }

    override fun onItemClick(item: GetPostsResponse) {
        val bundle = Bundle()
        bundle.putString(key_title, item.title)
        bundle.putString(key_body, item.body)

        val postDetailFragment = PostDetailFragment()
        postDetailFragment.arguments = bundle
        mainActivity?.changeFragment(postDetailFragment)
    }

}