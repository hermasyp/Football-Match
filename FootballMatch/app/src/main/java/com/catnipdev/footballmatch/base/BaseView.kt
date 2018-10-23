package com.catnipdev.footballmatch.base

interface BaseView {
    fun showLoadingProgress()
    fun dismissLoadingProgress()
    fun showErrorMessage(message:String?)
    fun showSuccessMessage(message:String?)
    fun showInfoMessage(message:String?)
    fun showWarningMessage(message:String?)
    fun showProgressBar()
    fun dismissProgressBar()
    fun closeActivity()
}