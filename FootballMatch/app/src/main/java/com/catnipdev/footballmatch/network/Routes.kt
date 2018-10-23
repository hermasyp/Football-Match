package com.catnipdev.footballmatch.network

import com.catnipdev.footballmatch.BuildConfig
import com.catnipdev.footballmatch.data.model.Events
import com.catnipdev.footballmatch.data.model.team.Teams
import io.reactivex.Observable

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface Routes {

    @GET("lookupteam.php")
    fun getDetailTeam(@Query("id") id : String?) : Call<Teams>

    @GET("lookupevent.php")
    fun getDetailEvent(@Query("id") id : String?) : Call<Events>

    @GET("eventspastleague.php?id=4328")
    fun getLastEvent() : Call<Events>

    @GET("eventsnextleague.php?id=4328")
    fun getNextEvent() : Observable<Events>

    companion object {
        fun create(): Routes {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            var okhttp = OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build()
            val retrofit = Retrofit.Builder().baseUrl(BuildConfig.TSDB_BASE_URL)
                    .client(okhttp)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
            return retrofit.create(Routes::class.java)
        }
    }

}