package com.techvista.assignment.base.utils


internal interface LoadingListener {

    fun onLoadingStarted(message: String)
    fun onLoadingFinished()
    fun onProgressUpdated(percentLoaded: Int)
}
