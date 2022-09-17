package com.example.myapplication1.ui.notifications.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.databinding.ItemNotificationBinding
import com.example.myapplication1.data.model.network.LocationResult

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {
    private var list: List<LocationResult> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<LocationResult>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding =
            ItemNotificationBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class LocationViewHolder(private val binding: ItemNotificationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(result: LocationResult) {
            binding.txtName.text = result.name
            binding.txtType.text = result.type
            binding.txtDimension.text = result.dimension
        }
    }
}
