package com.example.myapplication1.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication1.R
import com.example.myapplication1.base.BaseFragment
import com.example.myapplication1.common.Resource
import com.example.myapplication1.databinding.FragmentHomeBinding
import com.example.myapplication1.ui.home.adapter.CharacterAdapter
import com.example.myapplication1.ui.utils.isOnline
import com.example.myapplication1.ui.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    CharacterAdapter.ClickCharacter {
    private lateinit var adapter: CharacterAdapter
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[HomeViewModel::class.java]
    }

    override fun setupUI() {
        adapter = CharacterAdapter(this)
        binding.rvHome.adapter = adapter
        if (requireActivity().isOnline()) {
            viewModel.getCharacter()
        } else {
            requireActivity().showToast("У вас отсутсвует интернет соединение")
            binding.progress.isGone = true
        }
    }

    override fun setupObserver() {
        super.setupObserver()
        viewModel.liveDate.observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progress.isGone = true
                    requireActivity().showToast("Урааа")
                    it.data?.results?.let { it1 -> adapter.setList(it1) }
                }
                Resource.Status.LOADING -> binding.progress.isVisible = true
                Resource.Status.ERROR -> {
                    binding.progress.isVisible = true
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun listener(id: Int) {
        val bundle = Bundle()
        bundle.putInt("id", id)
        control.navigate(R.id.detailFragment, bundle)
    }
}