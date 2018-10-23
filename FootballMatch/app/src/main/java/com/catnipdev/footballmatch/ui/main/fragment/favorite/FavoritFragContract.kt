package com.catnipdev.footballmatch.ui.main.fragment.favorite

import android.content.Context
import com.catnipdev.footballmatch.data.model.Event
import com.hermasyp.quickmovie.base.BaseView

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface FavoritFragContract {
    interface Presenter{
        fun loadData(context: Context?)
    }
    interface View: BaseView {
        fun dataLoaded(data: List<Event?>?)
    }
}