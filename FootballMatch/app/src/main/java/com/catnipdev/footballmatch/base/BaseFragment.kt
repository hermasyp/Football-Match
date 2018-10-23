package com.hermasyp.quickmovie.base

import android.support.v4.app.Fragment
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.catnipdev.footballmatch.R
import com.jpardogo.android.googleprogressbar.library.ChromeFloatingCirclesDrawable
import es.dmoral.toasty.Toasty

open class BaseFragment : Fragment(),BaseView {
    lateinit var progressBar: ProgressBar

    fun initProgressBar(progressBar: ProgressBar): Unit {
        this.progressBar = progressBar
        this.progressBar.indeterminateDrawable = ChromeFloatingCirclesDrawable.Builder(context!!)
                .colors(resources.getIntArray(R.array.pb_color))
                .build()

    }

    override fun showLoadingProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismissLoadingProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun showErrorMessage(message: String?) {
        Toasty.error(context!!, message.toString(), Toast.LENGTH_SHORT, true).show();
    }

    override fun showSuccessMessage(message: String?) {
        Toasty.success(context!!, message.toString(), Toast.LENGTH_SHORT, true).show();
    }

    override fun showInfoMessage(message: String?) {
        Toasty.info(context!!, message.toString(), Toast.LENGTH_SHORT, true).show();
    }
    override fun showWarningMessage(message: String?) {
        Toasty.warning(context!!, message.toString(), Toast.LENGTH_SHORT, true).show();
    }
    override fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    override fun dismissProgressBar() {
        progressBar.visibility = View.GONE
    }

    override fun closeActivity() {
        activity?.finish()
    }

}