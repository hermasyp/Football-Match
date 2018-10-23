package com.catnipdev.footballmatch.ui.detail

import com.catnipdev.footballmatch.data.model.Event
import com.catnipdev.footballmatch.data.model.team.Team
import com.hermasyp.quickmovie.base.BaseView

interface DetailContract {
    interface View : BaseView{
        fun homeTeamLoaded(team : Team?)
        fun awayTeamLoaded(team : Team?)
        fun detailEventLoaded(event: Event?)
    }
    interface Presenter{
        fun loadTeamData(event : Event)
        fun loadDetailEvent(id :String)
    }
}