package com.catnipdev.footballmatch.ui.main.fragment.lastmatch

import com.catnipdev.footballmatch.data.model.Events
import com.catnipdev.footballmatch.network.Routes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LastMatchPresenter(val view:LastMatchContract.View):LastMatchContract.Presenter {
    override fun loadData() {
        view.showProgressBar()
        Routes.create().getLastEvent().enqueue(object : Callback<Events>{
            override fun onFailure(call: Call<Events>, t: Throwable) {
                view.showErrorMessage("Somethings wrong when getting data.")
            }
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                view.dismissProgressBar()
                view.dataLoaded(response.body()?.events)
            }
        })
    }
}