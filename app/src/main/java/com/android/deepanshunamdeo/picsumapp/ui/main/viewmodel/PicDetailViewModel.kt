package com.android.deepanshunamdeo.picsumapp.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.android.deepanshunamdeo.picsumapp.data.model.PicDetails
import com.android.deepanshunamdeo.picsumapp.data.repository.PicDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class PicDetailViewModel @Inject constructor(private val picDetailRepository: PicDetailRepository):ViewModel() {

    val getAllPicDetails : LiveData<List<PicDetails>> = picDetailRepository.getPicsDetails().catch {
        e->
        Log.e("TAG", ""+e.localizedMessage)
    }.asLiveData()
}