package com.catnipdev.footballmatch.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class SQLiteHelper(context : Context) : ManagedSQLiteOpenHelper(context,"FavoriteEvent.db",null,1){
    companion object {
        private var instance : SQLiteHelper? = null

        @Synchronized
        fun getInstance(context: Context) : SQLiteHelper{
            if(instance == null){
                instance = SQLiteHelper(context.applicationContext)
            }
            return instance as SQLiteHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {

        db?.createTable(FavoriteEvent.TABLE_FAVORITE_EVENT,true,
                FavoriteEvent.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                FavoriteEvent.ID_EVENT to TEXT + UNIQUE,
                FavoriteEvent.ID_LEAGUE to TEXT ,
                FavoriteEvent.DATE_EVENT to TEXT,
                FavoriteEvent.HOME_TEAM to TEXT,
                FavoriteEvent.AWAY_TEAM to TEXT,
                FavoriteEvent.HOME_SCORE to TEXT,
                FavoriteEvent.AWAY_SCORE to TEXT
                )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(FavoriteEvent.TABLE_FAVORITE_EVENT, true)
    }

}

val Context.database : SQLiteHelper
    get() = SQLiteHelper.getInstance(applicationContext)