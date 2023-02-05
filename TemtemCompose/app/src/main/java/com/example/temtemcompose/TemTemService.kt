package com.example.temtemcompose

import com.example.temtemcompose.models.TemTem
import com.example.temtemcompose.models.TemType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface TemTemService {

    @GET("temtems")
    suspend fun listTemTem(): Response<ArrayList<TemTem>>

    @GET("types")
    suspend fun getTypes(): Response<ArrayList<TemType>>

    @GET("temtems/{id}")
    suspend fun getTemTem(@Path("id") id: Int): Response<TemTem>
}

object TemTemServiceHelper {
    private const val BASE_URL = "https://temtem-api.mael.tech/api/"

    fun getInstance(): Retrofit {
        val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        val mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()


        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
    }
}