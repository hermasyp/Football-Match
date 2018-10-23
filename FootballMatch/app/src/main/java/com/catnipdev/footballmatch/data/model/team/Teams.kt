package com.catnipdev.footballmatch.data.model.team

import com.google.gson.annotations.SerializedName

data class Teams(

	@field:SerializedName("teams")
	val teams: List<Team?>? = null
)