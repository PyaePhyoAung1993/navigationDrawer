package com.tmw.navigationdrawerexample.ui.popular

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
import kotlinx.android.synthetic.main.fragment_popular.*

class PopularFragment : Fragment() {

    private lateinit var popularViewModel: PopularViewModel
    private lateinit var popularAdapter : PopularAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_popular, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        popularViewModel = ViewModelProvider(this).get(PopularViewModel::class.java)

        popularAdapter = PopularAdapter()

        recyclerPopular.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = popularAdapter
        }
        observeViewmodel2()
    }
    private fun observeViewmodel2() {
        popularViewModel.getResultPopular().observe(
            viewLifecycleOwner, Observer { popular ->
                popularAdapter.updatePopular(popular.results)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        popularViewModel.loadResult2()
    }
}
