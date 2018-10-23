package com.catnipdev.footballmatch.ui.main.fragment.favorite

import android.content.Context
import com.catnipdev.footballmatch.data.local.FavoriteEventDao

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class FavoriteFragPresenter(val view : FavoritFragContract.View) : FavoritFragContract.Presenter{
    override fun loadData(context: Context?) {
        view.showProgressBar()
        view.dataLoaded(FavoriteEventDao(context!!).getAllFavorite())
        view.dismissProgressBar()
    }

}