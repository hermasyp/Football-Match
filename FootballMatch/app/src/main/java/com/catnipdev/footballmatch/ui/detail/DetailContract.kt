package com.catnipdev.footballmatch.ui.detail

import com.catnipdev.footballmatch.base.BaseView
import com.catnipdev.footballmatch.data.model.Event
import com.catnipdev.footballmatch.data.model.team.Team

interface DetailContract {
    interface View : BaseView {
        fun homeTeamLoaded(team : Team?)
        fun awayTeamLoaded(team : Team?)
        fun detailEventLoaded(event: Event?)
    }
    interface Presenter{
        fun loadTeamData(event : Event)
        fun loadDetailEvent(id :String)
    }
}