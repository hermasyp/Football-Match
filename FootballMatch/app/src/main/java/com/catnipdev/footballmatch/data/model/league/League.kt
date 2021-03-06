package com.catnipdev.footballmatch.data.model.league

import com.google.gson.annotations.SerializedName

data class League(

	@field:SerializedName("strLeagueAlternate")
	val strLeagueAlternate: String? = null,

	@field:SerializedName("strLeague")
	val strLeague: String? = null,

	@field:SerializedName("strSport")
	val strSport: String? = null,

	@field:SerializedName("idLeague")
	val idLeague: String? = null
)