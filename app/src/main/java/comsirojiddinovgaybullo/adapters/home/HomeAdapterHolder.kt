package comsirojiddinovgaybullo.adapters.home

import androidx.recyclerview.widget.RecyclerView
import comsirojiddinovgaybullo.core.di.module.Data.RecData.HomeData
import comsirojiddinovgaybullo.exam.databinding.HomeItemBinding


class HomeAdapterHolder(val binding: HomeItemBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindData (data :HomeData){
        binding.homeTitle.text = data.dictionary

    }
}
