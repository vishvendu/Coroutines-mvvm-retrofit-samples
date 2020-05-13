package com.vishvendu.coroutines_mvvm_retrofit_samples.repository

import com.vishvendu.coroutines_mvvm_retrofit_samples.network.RetrofitBuilderInstance

class NowPlayingMovieRepository {

    suspend fun getNowPlayingMovieFromServer(page : Int) = RetrofitBuilderInstance.getMoviesAPIService.getNowPlayingMovies(page)

}