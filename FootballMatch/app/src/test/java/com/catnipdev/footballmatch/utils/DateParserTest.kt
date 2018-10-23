package com.catnipdev.footballmatch.utils

import android.annotation.SuppressLint
import org.junit.Assert.*
import org.junit.Test

/**
 * Written with love by Muhammad Hermas Yuda Pamungkas
 * Github : https://github.com/hermasyp
 */
class DateParserTest{
    @SuppressLint("SimpleDateFormat")
    fun testParseStringToDate(){
        //Contoh Benar
        assertEquals("Saturday , 27 Oct 2018",DateParser.parseToDateID("2018-10-27"))
        //Contoh Salah
       // assertEquals("Saturday , 27 Oct 2017",DateParser.parseToDateID("2018-10-27"))
    }
}