package com.android.deepanshunamdeo.picsumapp.data.api

import androidx.lifecycle.LiveData
import com.android.deepanshunamdeo.picsumapp.data.model.PicDetails
import retrofit2.http.GET

interface ApiService {

    @GET("list")
    suspend fun getPicsDetails(): List<PicDetails>
}