package com.techvista.assignment.Modules.main.viewmodel

import android.app.Application
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.techvista.assignment.Modules.main.database.PostItemDao
import com.techvista.assignment.Modules.main.models.GetPostsResponse
import com.techvista.assignment.R
import com.techvista.assignment.base.network.API
import com.techvista.assignment.base.viewmodel.BaseViewModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainVM(application: Application, var postItemDao: PostItemDao) : BaseViewModel(application) {

    @Inject
    lateinit var api: API

    private lateinit var subscription: Disposable
    val loader: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()


    val posts: MutableLiveData<List<GetPostsResponse>> = MutableLiveData()

    init {
        getPosts()
    }

    fun getPosts() {
        subscription = Observable.fromCallable { postItemDao.getAllPosts() }
            .concatMap { dbPostList ->
                if (dbPostList.isEmpty())
                    api.getPosts().concatMap { apiPostList ->
                        postItemDao.insert(*apiPostList.toTypedArray())
                        Observable.just(apiPostList)
                    }
                else
                    Observable.just(dbPostList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe({ onRetrievePostsListStart() })
            .doOnTerminate({ onRetrievePostsListFinish() })
            .subscribe(
                { result -> onSuccess(result) },
                { error -> onError() }
            )
    }

    private fun onRetrievePostsListStart() {
        loader.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostsListFinish() {
        loader.value = View.GONE
    }

    private fun onSuccess(postsList:List<GetPostsResponse>) {
        posts.value = postsList;
    }

    private fun onError() {
        errorMessage.value = R.string.something_wrong
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }
}