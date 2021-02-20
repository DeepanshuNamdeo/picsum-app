package com.android.deepanshunamdeo.picsumapp.data.api

import com.android.deepanshunamdeo.picsumapp.data.model.PicDetails
import javax.inject.Inject

class ApiServiceImplementation @Inject
constructor(private val apiService: ApiService) {

    suspend fun getPicsDetails(): List<PicDetails> = apiService.getPicsDetails()
}