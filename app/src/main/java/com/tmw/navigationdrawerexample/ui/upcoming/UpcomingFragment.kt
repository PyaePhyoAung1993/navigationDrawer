package com.tmw.navigationdrawerexample.ui.upcoming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tmw.navigationdrawerexample.R
import com.tmw.navigationdrawerexample.ui.popular.PopularAdapter
import com.tmw.navigationdrawerexample.ui.popular.PopularViewModel
import kotlinx.android.synthetic.main.fragment_popular.*
import kotlinx.android.synthetic.main.fragment_upcoming.*

class UpcomingFragment : Fragment() {

    lateinit var upcomingViewModel: UpcomingViewModel
    lateinit var upcomingAdapter: UpcomingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        upcomingViewModel = ViewModelProvider(this).get(UpcomingViewModel::class.java)

        upcomingAdapter = UpcomingAdapter()

        recyclerUpcoming.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = upcomingAdapter
        }
        observeViewmodel2()
    }
    private fun observeViewmodel2() {
        upcomingViewModel.getResultPopular().observe(
            viewLifecycleOwner, Observer { upcoming ->
                upcomingAdapter.updatePopular(upcoming.results)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        upcomingViewModel.loadResult2()
    }
}


