package com.catnipdev.footballmatch.ui.detail

import com.catnipdev.footballmatch.data.model.Event
import com.catnipdev.footballmatch.data.model.Events
import com.catnipdev.footballmatch.data.model.team.Teams
import com.catnipdev.footballmatch.network.Routes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPresenter(val view:DetailContract.View) : DetailContract.Presenter{
    override fun loadDetailEvent(id:String) {
        Routes.create().getDetailEvent(id).enqueue(object : Callback<Events>{
            override fun onResponse(call: Call<Events>, response: Response<Events>) {
                view.detailEventLoaded(response.body()?.events?.get(0))
            }

            override fun onFailure(call: Call<Events>, t: Throwable) {
                view.showErrorMessage("Somethings wrong when getting data.")
            }

        })
    }

    override fun loadTeamData(event: Event) {
        Routes.create().getDetailTeam(event.idHomeTeam).enqueue(object : Callback<Teams>{
            override fun onResponse(call: Call<Teams>, response: Response<Teams>) {
                view.homeTeamLoaded(response.body()?.teams?.get(0))
            }
            override fun onFailure(call: Call<Teams>, t: Throwable) {
                view.showErrorMessage("Somethings wrong when getting data.")

            }
        })
        Routes.create().getDetailTeam(event.idAwayTeam).enqueue(object : Callback<Teams>{
            override fun onResponse(call: Call<Teams>, response: Response<Teams>) {
                view.awayTeamLoaded(response.body()?.teams?.get(0))
            }
            override fun onFailure(call: Call<Teams>, t: Throwable) {
                view.showErrorMessage("Somethings wrong when getting data.")

            }
        })

    }


}
