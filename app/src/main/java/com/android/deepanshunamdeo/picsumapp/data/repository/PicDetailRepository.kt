package com.android.deepanshunamdeo.picsumapp.data.repository

import com.android.deepanshunamdeo.picsumapp.data.api.ApiServiceImplementation
import com.android.deepanshunamdeo.picsumapp.data.model.PicDetails
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PicDetailRepository @Inject
constructor(private val apiServiceImplementation: ApiServiceImplementation) {

    fun getPicsDetails():Flow<List<PicDetails>> = flow {
        val response = apiServiceImplementation.getPicsDetails()
        emit(response)
    }.flowOn(Dispatchers.IO)

}