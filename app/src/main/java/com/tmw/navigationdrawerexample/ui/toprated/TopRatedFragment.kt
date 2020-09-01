package com.tmw.navigationdrawerexample.ui.toprated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmw.navigationdrawerexample.R
import com.tmw.navigationdrawerexample.ui.nowplaying.NowPlayingAdapter
import com.tmw.navigationdrawerexample.ui.nowplaying.NowPlayingViewModel
import kotlinx.android.synthetic.main.fragment_nowplaying.*
import kotlinx.android.synthetic.main.fragment_toprated.*

class TopRatedFragment : Fragment() {

    private lateinit var topratedViewModel: TopRatedViewModel
    private lateinit var topRatedAdapter: TopRatedAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_toprated,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        topratedViewModel = ViewModelProvider(this).get(TopRatedViewModel::class.java)

        topRatedAdapter = TopRatedAdapter()

        recyclerTopRated.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = topRatedAdapter
        }
        observeViewmodel3()
    }

    private fun observeViewmodel3() {
        topratedViewModel.getResultTopRated().observe(
            viewLifecycleOwner, Observer { toprated ->
                topRatedAdapter.updateTopRated(toprated.results)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        topratedViewModel.loadResult3()
    }
}