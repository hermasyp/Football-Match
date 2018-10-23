package com.catnipdev.footballmatch.data.model.league

import com.google.gson.annotations.SerializedName

data class Leagues(

	@field:SerializedName("leagues")
	val leagues: List<League?>? = null
)