package com.catnipdev.footballmatch.ui.main.fragment.favorite


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.catnipdev.footballmatch.R
import com.catnipdev.footballmatch.data.model.Event
import com.catnipdev.footballmatch.ui.adapter.MatchListAdapter
import com.catnipdev.footballmatch.ui.detail.DetailActivity
import com.hermasyp.quickmovie.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_favorite.view.*
import org.jetbrains.anko.support.v4.startActivity


class FavoriteFrag : BaseFragment(),FavoritFragContract.View  {
    lateinit var presenter: FavoritFragContract.Presenter
    lateinit var v:View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_favorite, container, false)
        presenter = FavoriteFragPresenter(this)
        initProgressBar(v.pbFavMatch)
        v.rvFavorite.adapter = null
        v.rvFavorite.layoutManager = LinearLayoutManager(context)
        return v
    }

    override fun onResume() {
        super.onResume()
        presenter.loadData(context)

    }

    override fun dataLoaded(data: List<Event?>?) {
        d("dataLoaded ","Data : "+data?.size)
        val adapter = MatchListAdapter(context,data){
            startActivity<DetailActivity>("event" to it)
        }
        v.rvFavorite.adapter = adapter
    }


}
