package comsirojiddinovgaybullo.adapters.details

import androidx.recyclerview.widget.RecyclerView
import comsirojiddinovgaybullo.core.di.module.Data.UserData.NoteItem
import comsirojiddinovgaybullo.exam.databinding.DictionareyItemBinding

class DictionaryAdapterHolder(val binding: DictionareyItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(data :NoteItem){
        binding.dictionaryTitle.text = data.title
    }
}