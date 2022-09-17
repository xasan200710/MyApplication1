package com.example.myapplication1.ui.dashboard

import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication1.base.BaseFragment
import com.example.myapplication1.common.Resource
import com.example.myapplication1.databinding.FragmentDashboardBinding
import com.example.myapplication1.ui.dashboard.adapter.EpisodeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment :
    BaseFragment<FragmentDashboardBinding>(FragmentDashboardBinding::inflate) {
    private lateinit var adapter: EpisodeAdapter
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[DashboardViewMadel::class.java]
    }

    override fun setupUI() {
        adapter = EpisodeAdapter()
        binding.rvEpisode.adapter = adapter
        viewModel.getEpisode()
    }

    override fun setupObserver() {
        super.setupObserver()
        viewModel.episode.observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressDas.isGone = true
                    it.data?.results?.let { it1 -> adapter.setList(it1) }
                }
                Resource.Status.LOADING -> binding.progressDas.isVisible = true
                Resource.Status.ERROR -> {
                    binding.progressDas.isVisible = true
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}