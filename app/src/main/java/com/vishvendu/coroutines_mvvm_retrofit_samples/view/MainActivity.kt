 package com.vishvendu.coroutines_mvvm_retrofit_samples.view
 import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.vishvendu.coroutines_mvvm_retrofit_samples.R
import com.vishvendu.coroutines_mvvm_retrofit_samples.viewmodel.NowPlayingViewModel

 class MainActivity : AppCompatActivity() {

     private lateinit var mViewModel: NowPlayingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewModel = ViewModelProvider(this).get(NowPlayingViewModel::class.java)
        observerNowPlayingdata()
    }

     private fun observerNowPlayingdata() {

         mViewModel.getNowPlayingMoviedataFromrepository(1)
         mViewModel.mNowPlayingMovieMutableLiveData.observe(this, Observer {NowPlayingMovieData ->
             println(NowPlayingMovieData.results)
         })

     }
 }
