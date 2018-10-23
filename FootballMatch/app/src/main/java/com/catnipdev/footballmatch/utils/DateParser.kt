package com.catnipdev.footballmatch.utils

import java.text.SimpleDateFormat

object DateParser{
        fun parseToDateID(date:String?) : String {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            val dateFormatOutput = SimpleDateFormat("EEEE , dd MMM yyyy")
            return dateFormatOutput.format(dateFormat.parse(date))
        }
}