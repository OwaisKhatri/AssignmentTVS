package com.techvista.assignment.base.network

import com.techvista.assignment.Modules.main.models.GetPostsResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface API {

    @GET("posts")
    fun getPosts() : Observable<ArrayList<GetPostsResponse>>
}