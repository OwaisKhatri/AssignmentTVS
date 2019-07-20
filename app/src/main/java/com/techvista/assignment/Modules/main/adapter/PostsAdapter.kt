package com.techvista.assignment.Modules.main.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techvista.assignment.Modules.main.models.GetPostsResponse
import com.techvista.assignment.R
import com.techvista.assignment.base.utils.RVItemClickListener
import com.techvista.assignment.base.utils.inflate

class PostsAdapter : RecyclerView.Adapter<PostsVH>() {

    private val postsList: ArrayList<GetPostsResponse> = ArrayList()
    private lateinit var listener: RVItemClickListener<GetPostsResponse>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsVH {
        val view = parent.inflate(R.layout.row_post)
        return PostsVH(view)
    }

    override fun getItemCount(): Int = postsList.size

    override fun onBindViewHolder(holder: PostsVH, position: Int) {
        val postItem = postsList.get(position)
        holder.onBind(postItem, listener)
    }

    fun setListeners(listener: RVItemClickListener<GetPostsResponse>) {
        this.listener = listener
    }

    fun updateLists(postsList: List<GetPostsResponse>) {
        this.postsList.clear()
        this.postsList.addAll(postsList)
        notifyDataSetChanged()
    }
}