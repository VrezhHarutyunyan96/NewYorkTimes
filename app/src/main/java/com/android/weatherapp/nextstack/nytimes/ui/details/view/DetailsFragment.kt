package com.android.weatherapp.nextstack.nytimes.ui.details.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.android.weatherapp.nextstack.nytimes.R
import com.android.weatherapp.nextstack.nytimes.base.BaseFragment
import com.android.weatherapp.nextstack.nytimes.databinding.FragmentDetailsBinding
import com.android.weatherapp.nextstack.nytimes.ui.details.viewmodel.DetailsSharedVIewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(R.layout.fragment_details) {

    companion object {
        val Tag = "DetailsFragment"
        fun getInstance() = DetailsFragment().apply {
            arguments = Bundle()
        }
    }

    // News details Shared View Model
    private val newsDetailsSharedVIewModel: DetailsSharedVIewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
    }

    private fun initViewModel() {
        newsDetailsSharedVIewModel.getNews().observe(viewLifecycleOwner, Observer {
            binding.apply {
                newsItem = it
                url = it.media?.get(0)?.mediaMetadata?.get(2)?.url
            }
        })
    }

}