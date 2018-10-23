package com.catnipdev.footballmatch.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.catnipdev.footballmatch.R
import com.catnipdev.footballmatch.data.model.Event
import com.catnipdev.footballmatch.utils.DateParser
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_match.*

class MatchListAdapter(private val context: Context?, private val items :List<Event?>?, private val listener: (Event?) -> Unit) : RecyclerView.Adapter<MatchListAdapter.MatchViewHolder>() {

    private var data: List<Event?>? = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_match, parent, false)
        )
    }

    override fun getItemCount() = data?.size ?: 0

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) = holder.bind(data!![position],listener)


    class MatchViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),LayoutContainer {
        fun bind(item: Event?, listener: (Event?) -> Unit){
            // TODO: Bind the data with View
            txtMatchDate.text = DateParser.parseToDateID(item?.dateEvent)
            txtAwayTeam.text = item?.strAwayTeam
            txtHomeTeam.text = item?.strHomeTeam
            txtHomeScore.text = item?.intHomeScore
            txtAwayScore.text = item?.intAwayScore
            containerView.setOnClickListener {
                // TODO: Handle on click
                listener(item)
            }
        }
    }
}