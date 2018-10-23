package com.catnipdev.footballmatch.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat


object DateParser{
        @SuppressLint("SimpleDateFormat")
        fun parseToDateID(date:String?) : String {
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            val dateFormatOutput = SimpleDateFormat("EEEE , dd MMM yyyy")
            return dateFormatOutput.format(dateFormat.parse(date))
        }
}