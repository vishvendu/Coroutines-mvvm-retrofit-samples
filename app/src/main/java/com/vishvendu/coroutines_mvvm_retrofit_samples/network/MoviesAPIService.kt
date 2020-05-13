package com.vishvendu.coroutines_mvvm_retrofit_samples.network


import com.vishvendu.darktime.model.movies.nowplayingmovie.NowPlayingMovies
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPIService {

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(@Query("page") page: Int): Response<NowPlayingMovies>

}