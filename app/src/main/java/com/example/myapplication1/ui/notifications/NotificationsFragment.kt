package com.example.myapplication1.ui.notifications

import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication1.base.BaseFragment
import com.example.myapplication1.common.Resource
import com.example.myapplication1.databinding.FragmentNotificationsBinding
import com.example.myapplication1.ui.notifications.adapter.LocationAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationsFragment :
    BaseFragment<FragmentNotificationsBinding>(FragmentNotificationsBinding::inflate) {
    private lateinit var adapter: LocationAdapter
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[NotificationViewMadel::class.java]
    }

    override fun setupUI() {
        adapter = LocationAdapter()
        binding.rvLocation.adapter = adapter
        viewModel.getLocation()
    }

    override fun setupObserver() {
        super.setupObserver()
        viewModel.location.observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressNot.isGone = true
                    it.data?.results?.let { it1 -> adapter.setList(it1) }
                }
                Resource.Status.LOADING -> binding.progressNot.isVisible = true
                Resource.Status.ERROR -> {
                    binding.progressNot.isVisible = true
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}