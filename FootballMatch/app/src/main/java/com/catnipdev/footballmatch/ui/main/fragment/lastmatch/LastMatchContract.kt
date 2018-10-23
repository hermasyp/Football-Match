package com.catnipdev.footballmatch.ui.main.fragment.lastmatch

import com.catnipdev.footballmatch.data.model.Event
import com.hermasyp.quickmovie.base.BaseView

interface LastMatchContract {
    interface Presenter{
        fun loadData()
    }
    interface View:BaseView{
        fun dataLoaded(data: List<Event?>?)
    }
}