package com.catnipdev.footballmatch.ui.main.fragment.nextmatch

import com.catnipdev.footballmatch.data.model.Events
import com.hermasyp.quickmovie.network.Routes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NextMatchPresenter(val view:NextMatchContract.View) : NextMatchContract.Presenter {
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
}