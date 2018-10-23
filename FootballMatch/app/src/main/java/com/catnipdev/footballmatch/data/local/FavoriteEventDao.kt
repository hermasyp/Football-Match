package com.catnipdev.footballmatch.data.local

import android.content.Context
import android.database.sqlite.SQLiteConstraintException
import android.util.Log.d
import android.widget.Toast
import com.catnipdev.footballmatch.data.model.Event
import es.dmoral.toasty.Toasty
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class FavoriteEventDao(ctx: Context) {
    var context : Context
    init {
        this.context = ctx
    }

    fun addFavorite(event : Event){
        try {
            context.database.use {
                insert(
                        FavoriteEvent.TABLE_FAVORITE_EVENT,
                        FavoriteEvent.ID_EVENT to event.idEvent,
                        FavoriteEvent.ID_LEAGUE to event.idLeague,
                        FavoriteEvent.DATE_EVENT to event.dateEvent,
                        FavoriteEvent.HOME_TEAM to event.strHomeTeam,
                        FavoriteEvent.AWAY_TEAM to event.strAwayTeam,
                        FavoriteEvent.HOME_SCORE to event.intHomeScore,
                        FavoriteEvent.AWAY_SCORE to event.intAwayScore
                        )
            }
        }catch (e : SQLiteConstraintException){
            Toasty.error(context, e.toString(), Toast.LENGTH_SHORT, true).show();

        }
    }

    fun getFavoriteByID(id : String): Boolean{
        var found = false
        context.database.use {
            val result = select(FavoriteEvent.TABLE_FAVORITE_EVENT)
                    .whereArgs("ID_EVENT = {id}",
                            "id" to id)
            val favorite = result.parseList(classParser<FavoriteEvent>())
            if (!favorite.isEmpty()) found = true else found = false
        }
        return found

    }
    fun getAllFavorite() : List<Event>?{
        var data : List<FavoriteEvent> = mutableListOf()
        context.database.use {
            val result = select(FavoriteEvent.TABLE_FAVORITE_EVENT)
            data = result.parseList(classParser<FavoriteEvent>())
            d("DAO","total data :" +data.size)
        }
        d("DAO","total data after parse:" +data.size)

        return Event.parseEvent(data)
    }

    fun deleteFavorite(id : String){
        try {
            context.database.use {
                delete(FavoriteEvent.TABLE_FAVORITE_EVENT, "(ID_EVENT = {id})",
                        "id" to id)
            }
        } catch (e: SQLiteConstraintException){
            Toasty.error(context, e.toString(), Toast.LENGTH_SHORT, true).show();
        }
    }

}