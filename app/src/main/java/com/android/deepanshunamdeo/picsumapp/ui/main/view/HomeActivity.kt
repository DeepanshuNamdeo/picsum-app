package com.android.deepanshunamdeo.picsumapp.ui.main.view

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.android.deepanshunamdeo.picsumapp.R
import com.android.deepanshunamdeo.picsumapp.data.model.PicDetails
import com.android.deepanshunamdeo.picsumapp.ui.main.adapter.PicDetailsAdapter
import com.android.deepanshunamdeo.picsumapp.ui.main.viewmodel.PicDetailViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_home.*

@AndroidEntryPoint

class HomeActivity : AppCompatActivity() {

    private lateinit var adapter: PicDetailsAdapter
    private val picDetailViewModel : PicDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupUI()
        setupObserver()

    }

    private fun setupUI() {
        recyclerView_pic_details.layoutManager = GridLayoutManager(this, 2)
        adapter = PicDetailsAdapter(arrayListOf(), this)
        recyclerView_pic_details.addItemDecoration(
            DividerItemDecoration(
                recyclerView_pic_details.context,
                (recyclerView_pic_details.layoutManager as GridLayoutManager).orientation
            )
        )
        recyclerView_pic_details.adapter = adapter
    }

    private fun setupObserver() {
        picDetailViewModel.getAllPicDetails.observe(this, Observer {
            this.progressBar_loading.visibility= View.GONE
            this.recyclerView_pic_details.visibility= View.VISIBLE
            renderList(it)
        })
    }

    private fun renderList(picture: List<PicDetails>) {
        adapter.addData(picture)
        adapter.notifyDataSetChanged()
    }
}