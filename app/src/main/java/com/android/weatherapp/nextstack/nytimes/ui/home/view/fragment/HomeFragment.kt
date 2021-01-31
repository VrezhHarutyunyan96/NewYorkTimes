package com.android.weatherapp.nextstack.nytimes.ui.home.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.weatherapp.nextstack.nytimes.R
import com.android.weatherapp.nextstack.nytimes.base.BaseFragment
import com.android.weatherapp.nextstack.nytimes.databinding.FragmentHomeBinding
import com.android.weatherapp.nextstack.nytimes.ui.details.view.DetailsFragment
import com.android.weatherapp.nextstack.nytimes.ui.details.viewmodel.DetailsSharedVIewModel
import com.android.weatherapp.nextstack.nytimes.ui.home.view.adapter.HomeNewsFeedAdapter
import com.android.weatherapp.nextstack.nytimes.ui.home.viewmodel.HomeViewModel
import com.android.weatherapp.nextstack.nytimes.utils.FragmentAnimationType
import com.android.weatherapp.nextstack.nytimes.utils.openFragment
import org.koin.android.viewmodel.ext.android.sharedViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    companion object {
        fun getInstance() = HomeFragment().apply {
            arguments = Bundle()
        }
    }

    // News feed View Model
    private val homeViewModel: HomeViewModel by viewModel()

    // News details Shared ViewModel
    private val newsDetailsSharedVIewModel: DetailsSharedVIewModel by sharedViewModel()

    // News Recycler adapter
    private val recyclerAdapter: HomeNewsFeedAdapter by lazy {
        val adapter = HomeNewsFeedAdapter { newsItem ->
            newsDetailsSharedVIewModel.setNews(newsItem)
            openFragment(
                DetailsFragment.getInstance(),
                R.id.main_container,
                DetailsFragment.Tag,
                true,
                isReplace = false,
                animationType = FragmentAnimationType.SLIDE_VERTICAL
            )
        }
        binding.rvNews.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNews.adapter = adapter
        return@lazy adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        initViewModel()
        return super.onCreateView(inflater, container, savedInstanceState)
    }


    private fun initViewModel() {
        homeViewModel.getNewsFeedLiveData().observe(viewLifecycleOwner, Observer {
            it.let {
                recyclerAdapter.setNewsFeed(it)
            }
        })
    }

}