package com.example.myapplication1.ui.detailChracter

import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.myapplication1.base.BaseFragment
import com.example.myapplication1.common.Resource
import com.example.myapplication1.databinding.FragmentDetailBinding
import com.example.myapplication1.ui.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {
    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[DetailCharacterVIewModel::class.java]
    }

    override fun setupUI() {
        val idCharacter = arguments?.getInt("id")
        viewModel.getCharacterById(idCharacter.toString().toInt())
    }

    override fun setupObserver() {
        super.setupObserver()
        viewModel.liveDate.observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    Glide.with(requireActivity()).load(it.data?.image).circleCrop()
                        .into(binding.imgDetailCharacter)
                    binding.txtNameDetailOne.text = it.data?.name
                    binding.txtStatusDetailOne.text = it.data?.status
                    binding.txtGenderDetailOne.text = it.data?.gender
                    binding.txtTypeDetailOne.text = it.data?.type
                    binding.txtLocationDetailOne.text = it.data?.location.toString()
                }
                Resource.Status.LOADING -> requireActivity().showToast("Loading")
                Resource.Status.ERROR -> requireActivity().showToast("Error")
            }
        }
    }
}