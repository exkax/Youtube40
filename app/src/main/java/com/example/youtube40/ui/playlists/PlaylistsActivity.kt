package com.example.youtube40.ui.playlists

import android.net.NetworkRequest
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtube40.base.BaseActivity
import com.example.youtube40.chekNetwork.ConnectionLiveData
import com.example.youtube40.databinding.ActivityPlaylistsBinding
import com.example.youtube40.model.Item

class PlaylistsActivity : BaseActivity<PlaylistViewModel, ActivityPlaylistsBinding>() {

    private val adapter = PlaylistAdapter()
    private lateinit var chekNetwork: ConnectionLiveData
    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }

    override fun initView() {
        binding.recyclerPlaylist.layoutManager = LinearLayoutManager(this)
        binding.recyclerPlaylist.adapter = adapter
    }
    override fun initViewModel() {
        viewModel.getPlaylists().observe(this) {
            adapter.setList(it.items as ArrayList<Item>)
        }
    }

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityPlaylistsBinding {
        return ActivityPlaylistsBinding.inflate(inflater)
    }

    override fun checkInternet() {
        chekNetwork = ConnectionLiveData(this)
        chekNetwork.observe(this) {
            if (it == true) {
                initViewModel()
                binding.recyclerPlaylist.isVisible = true
                binding.layoutNoNetwork.root.isInvisible = true
            } else {
                binding.recyclerPlaylist.isInvisible = true
                binding.layoutNoNetwork.root.isVisible = true
            }
        }
    }
}