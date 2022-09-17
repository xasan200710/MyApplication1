package com.example.myapplication1.ui.dashboard.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.databinding.ItemDashboardBinding
import com.example.myapplication1.data.model.network.EpisodeResult

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder>() {
    private var list: List<EpisodeResult> = mutableListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<EpisodeResult>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val binding =
            ItemDashboardBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return EpisodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class EpisodeViewHolder(private val binding: ItemDashboardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(result: EpisodeResult) {
            binding.txtName.text = result.name
            binding.txtEpisode.text = result.episode
            binding.txtAirDate.text = result.airDate
        }
    }
}
