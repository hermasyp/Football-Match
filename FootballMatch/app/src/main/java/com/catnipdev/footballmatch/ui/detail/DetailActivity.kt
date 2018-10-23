package com.catnipdev.footballmatch.ui.detail

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.catnipdev.footballmatch.R
import com.catnipdev.footballmatch.R.drawable.ic_add_to_favorites
import com.catnipdev.footballmatch.R.drawable.ic_added_to_favorites
import com.catnipdev.footballmatch.data.local.FavoriteEventDao
import com.catnipdev.footballmatch.data.model.Event
import com.catnipdev.footballmatch.data.model.team.Team
import com.catnipdev.footballmatch.utils.DateParser
import com.catnipdev.footballmatch.utils.Splitter
import com.hermasyp.quickmovie.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity(),DetailContract.View {
    lateinit var presenter: DetailContract.Presenter

    private var menuItem: Menu? = null

    lateinit var e:Event
    lateinit var db:FavoriteEventDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter = DetailPresenter(this)
        e = intent.getParcelableExtra("event")
        db = FavoriteEventDao(this)
    }
    fun initdata(event:Event?){
        txtHomeTeam.text = event?.strHomeTeam
        txtHomeScore.text = event?.intHomeScore
        txtAwayScore.text = event?.intAwayScore
        txtAwayTeam.text = event?.strAwayTeam
        txtGoalHome.text = Splitter.splitWithPattern(event?.strHomeGoalDetails ?: "")
        txtGoalAway.text = Splitter.splitWithPattern(event?.strAwayGoalDetails ?: "")
        txtHomeKeeper.text = Splitter.splitWithPattern(event?.strHomeLineupGoalkeeper ?: "")
        txtAwayKeeper.text = Splitter.splitWithPattern(event?.strAwayLineupGoalkeeper ?: "")
        txtDefenseHome.text = Splitter.splitWithPattern(event?.strHomeLineupDefense ?: "")
        txtDefenseAway.text = Splitter.splitWithPattern(event?.strAwayLineupDefense ?: "")
        txtMidfieldHome.text = Splitter.splitWithPattern(event?.strHomeLineupMidfield ?: "")
        txtMidfieldAway.text = Splitter.splitWithPattern(event?.strAwayLineupMidfield ?: "")
        txtForwardHome.text = Splitter.splitWithPattern(event?.strHomeLineupForward ?: "")
        txtForwardAway.text = Splitter.splitWithPattern(event?.strAwayLineupForward ?: "")
        txtSubtituteHome.text = Splitter.splitWithPattern(event?.strHomeLineupSubstitutes ?: "")
        txtSubtituteAway.text = Splitter.splitWithPattern(event?.strAwayLineupSubstitutes ?: "")
        txtDateDetail.text = DateParser.parseToDateID(event?.dateEvent)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId){
            android.R.id.home ->{
                finish()
                true
            }
            R.id.item_add_fav ->{
                if(db.getFavoriteByID(e.idEvent ?: "")){
                    db.deleteFavorite(e.idEvent?: "")
                    showInfoMessage("Favorite Deleted")
                }else {
                    db.addFavorite(e)
                    showInfoMessage("Favorite Added")
                }
                setFavoriteMatch()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }


    }
    override fun detailEventLoaded(event: Event?) {
        initdata(event)
        presenter.loadTeamData(event ?: Event())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_act_detail,menu)
        menuItem = menu
        setFavoriteMatch()
        return super.onCreateOptionsMenu(menu)
    }

    fun setFavoriteMatch() {
        if (db.getFavoriteByID(e?.idEvent?: ""))
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, ic_added_to_favorites)
        else
            menuItem?.getItem(0)?.icon = ContextCompat.getDrawable(this, ic_add_to_favorites)

    }

    override fun onResume() {
        super.onResume()
        presenter.loadDetailEvent(e.idEvent ?: "")
    }
    override fun homeTeamLoaded(team: Team?) {
        Glide.with(this)
                .load(team?.strTeamBadge)
                .into(imgHomeIcon)
    }

    override fun awayTeamLoaded(team: Team?) {
        Glide.with(this)
                .load(team?.strTeamBadge)
                .into(imgAwayIcon)
    }






}
