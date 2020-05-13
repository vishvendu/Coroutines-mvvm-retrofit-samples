package com.vishvendu.coroutines_mvvm_retrofit_samples.network

import com.vishvendu.coroutines_mvvm_retrofit_samples.BuildConfig.TMDB_API_KEY
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderInstance {

    private const val BASE_URL = "https://api.themoviedb.org/3/"


   private val interceptor = Interceptor { chain ->
        val url = chain.request().url().newBuilder().addQueryParameter("api_key", TMDB_API_KEY).addQueryParameter("language" ,"en-US").build()
        val request = chain.request()
            .newBuilder()
            .url(url)
            .build()
        chain.proceed(request)
    }

   private val apiClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()

    val getMoviesAPIService : MoviesAPIService by lazy {
        retrofitBuilder.build().create(MoviesAPIService::class.java)
    }



    private val retrofitBuilder : Retrofit.Builder by lazy{

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(apiClient)
            .addConverterFactory(GsonConverterFactory.create())

    }
}