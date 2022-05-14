package com.example.youtube40.ui.playlists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtube40.R
import com.example.youtube40.base.BaseActivity
import com.example.youtube40.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity<DetailViewModel, ActivityDetailBinding>() {
    override val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this)[DetailViewModel::class.java]
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(inflater)
    }

    override fun initView() {
        Toast.makeText(this, intent.getStringExtra("key"), Toast.LENGTH_SHORT).show()
    }

}