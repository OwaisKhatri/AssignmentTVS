package com.techvista.assignment.Modules.main.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.techvista.assignment.Modules.main.models.GetPostsResponse
import com.techvista.assignment.base.utils.RVItemClickListener
import kotlinx.android.synthetic.main.row_post.view.*

class PostsVH(itemView: View): RecyclerView.ViewHolder(itemView) {

    private var postTitle: TextView
    private var detailsBtn: TextView

    init {
        postTitle = itemView.tv_postTitle
        detailsBtn = itemView.detailsBtn

    }

    fun onBind(postItem: GetPostsResponse, listener: RVItemClickListener<GetPostsResponse>) {
        postTitle.text = postItem.title

        detailsBtn.setOnClickListener {
            listener.onItemClick(postItem)
        }
    }

}