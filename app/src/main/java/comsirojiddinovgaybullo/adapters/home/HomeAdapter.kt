package comsirojiddinovgaybullo.adapters.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import comsirojiddinovgaybullo.core.di.module.Data.RecData.HomeData
import comsirojiddinovgaybullo.exam.databinding.HomeItemBinding

class HomeAdapter : RecyclerView.Adapter<HomeAdapterHolder>() {

    var data = ArrayList<HomeData>()

    set(value) {
        data.clear()
        data.addAll(value)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterHolder =
        HomeAdapterHolder(
            HomeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: HomeAdapterHolder, position: Int) {
        holder.bindData(data = data[position])
    }

    override fun getItemCount(): Int = data.size


}