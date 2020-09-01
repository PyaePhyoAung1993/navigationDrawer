package com.tmw.navigationdrawerexample.ui.nowplaying

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmw.navigationdrawerexample.R
import kotlinx.android.synthetic.main.fragment_nowplaying.*

class NowPlayingFragment : Fragment() {

    private lateinit var nowplayingViewModel: NowPlayingViewModel
    private lateinit var nowplayingAdapter: NowPlayingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_nowplaying, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nowplayingViewModel = ViewModelProvider(this).get(NowPlayingViewModel::class.java)

        nowplayingAdapter = NowPlayingAdapter()

        recyclerNowPlaying.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = nowplayingAdapter
        }
        observeViewmodel1()
    }

    private fun observeViewmodel1() {
        nowplayingViewModel.getResultNowPlaying().observe(
            viewLifecycleOwner, Observer { nowplaying ->
                nowplayingAdapter.updateNowPlaying(nowplaying.results)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        nowplayingViewModel.loadResult1()
    }
}
