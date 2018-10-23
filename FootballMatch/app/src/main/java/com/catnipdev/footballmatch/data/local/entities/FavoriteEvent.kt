package com.catnipdev.footballmatch.data.local

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
data class FavoriteEvent(
        val id: Long?,
        val idEvent: String? = null,
        val idLeague: String? = null,
        val dateEvent: String? = null,
        val strHomeTeam: String? = null,
        val strAwayTeam: String? = null,
        val intHomeScore: String? = null,
        val intAwayScore: String? = null) {
    companion object {
        const val TABLE_FAVORITE_EVENT: String = "FAVORITE_EVENT"
        const val ID: String = "ID"
        const val ID_EVENT: String = "ID_EVENT"
        const val DATE_EVENT: String = "DATE_EVENT"
        const val ID_LEAGUE: String = "ID_LEAGUE"
        const val HOME_TEAM: String = "HOME_TEAM"
        const val AWAY_TEAM: String = "AWAY_TEAM"
        const val HOME_SCORE: String = "HOME_SCORE"
        const val AWAY_SCORE: String = "AWAY_SCORE"

    }
}