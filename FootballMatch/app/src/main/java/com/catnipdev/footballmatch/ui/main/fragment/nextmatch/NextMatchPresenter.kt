package com.catnipdev.footballmatch.ui.main.fragment.nextmatch

import com.catnipdev.footballmatch.data.model.Events
import com.catnipdev.footballmatch.network.Routes
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NextMatchPresenter(val view:NextMatchContract.View) : NextMatchContract.Presenter {
    override fun loadData() {
        view.showProgressBar()
        Routes.create().getNextEvent().
                subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            view.dismissProgressBar()
                            view.dataLoaded(it.events)
                        },
                        {
                            view.showErrorMessage("Somethings wrong when getting data.")
                        }
                )

    }

    /*
    override fun loadData() {
        view.showProgressBar()
        Routes.create().getNextEvent().enqueue(object : Callback<Events> {
            override fun onFailure(call: Call<Events>, t: Throwable) {
                view.showErrorMessage("Somethings wrong when getting data.")
            }
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                view.dismissProgressBar()
                view.dataLoaded(response?.body()?.events)
            }
        })
    }

    * */
}