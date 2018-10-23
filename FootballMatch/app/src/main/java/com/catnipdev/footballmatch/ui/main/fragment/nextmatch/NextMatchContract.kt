package com.catnipdev.footballmatch.ui.main.fragment.nextmatch

import com.catnipdev.footballmatch.base.BaseView
import com.catnipdev.footballmatch.data.model.Event

interface NextMatchContract {
    interface Presenter{
        fun loadData()
    }
    interface View: BaseView {
        fun dataLoaded(data: List<Event?>?)
    }
}
