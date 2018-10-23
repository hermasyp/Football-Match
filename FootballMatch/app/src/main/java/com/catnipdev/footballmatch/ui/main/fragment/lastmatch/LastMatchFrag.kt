package com.catnipdev.footballmatch.ui.main.fragment.lastmatch


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import com.catnipdev.footballmatch.R
import com.catnipdev.footballmatch.data.model.Event
import com.catnipdev.footballmatch.ui.detail.DetailActivity
import com.catnipdev.footballmatch.ui.adapter.MatchListAdapter
import com.hermasyp.quickmovie.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_last_match.view.*
import org.jetbrains.anko.support.v4.startActivity





class LastMatchFrag : BaseFragment(),LastMatchContract.View{
    lateinit var presenter: LastMatchContract.Presenter
    lateinit var v:View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_last_match, container, false)
        v.rvLastMatch.layoutManager = LinearLayoutManager(activity)
        v.rvLastMatch.adapter = null
        initProgressBar(v.pbLastMatch)
       // setHasOptionsMenu(true)
        presenter = LastMatchPresenter(this)
        return v
    }

    override fun onResume() {
        super.onResume()
        presenter.loadData()
    }

    override fun dataLoaded(data: List<Event?>?) {
        val adapter = MatchListAdapter(context,data){
            startActivity<DetailActivity>("event" to it)
        }
        v.rvLastMatch.adapter = adapter
    }



}
