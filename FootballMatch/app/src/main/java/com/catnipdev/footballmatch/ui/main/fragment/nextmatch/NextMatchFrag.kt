package com.catnipdev.footballmatch.ui.main.fragment.nextmatch


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.catnipdev.footballmatch.R
import com.catnipdev.footballmatch.base.BaseFragment
import com.catnipdev.footballmatch.data.model.Event
import com.catnipdev.footballmatch.ui.detail.DetailActivity
import com.catnipdev.footballmatch.ui.adapter.MatchListAdapter
import kotlinx.android.synthetic.main.fragment_next_match.view.*
import org.jetbrains.anko.support.v4.startActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class NextMatchFrag : BaseFragment(),NextMatchContract.View {
    lateinit var presenter: NextMatchContract.Presenter

    lateinit var v: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        v =  inflater.inflate(R.layout.fragment_next_match, container, false)
        v.rvNextMatch.layoutManager = LinearLayoutManager(activity)
        v.rvNextMatch.adapter = null
        initProgressBar(v.pbNextMatch)
        presenter = NextMatchPresenter(this)
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
        v.rvNextMatch.adapter = adapter
    }


}
