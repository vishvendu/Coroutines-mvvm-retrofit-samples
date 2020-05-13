package com.vishvendu.coroutines_mvvm_retrofit_samples.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vishvendu.coroutines_mvvm_retrofit_samples.repository.NowPlayingMovieRepository
import com.vishvendu.darktime.model.movies.nowplayingmovie.NowPlayingMovies
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO

class NowPlayingViewModel : ViewModel() {

    private val repository = NowPlayingMovieRepository()
    private val viewModelJob = Job()
    private val viewModelScope = CoroutineScope(IO+viewModelJob)
    val mNowPlayingMovieMutableLiveData = MutableLiveData<NowPlayingMovies>()

    fun getNowPlayingMoviedataFromrepository(page :Int){

        viewModelScope.launch {

            val response = repository.getNowPlayingMovieFromServer(page)

            withContext(Dispatchers.Main){

                if(response.isSuccessful){

                    mNowPlayingMovieMutableLiveData.value = response.body()
                }

            }


        }

    }

}