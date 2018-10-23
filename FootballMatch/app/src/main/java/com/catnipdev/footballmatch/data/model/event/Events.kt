package com.catnipdev.footballmatch.data.model

import com.google.gson.annotations.SerializedName

data class Events(

	@field:SerializedName("events")
	val events: List<Event?>? = null
)