package comsirojiddinovgaybullo.adapters.details

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import comsirojiddinovgaybullo.core.di.module.Data.UserData.NoteItem
import comsirojiddinovgaybullo.exam.databinding.DictionareyItemBinding

class DictionaryAdapter : RecyclerView.Adapter<DictionaryAdapterHolder>() {

    var data = ArrayList<NoteItem>()
    fun setData(d: List<NoteItem>) {
        this.data.clear()
        this.data.addAll(d)
        notifyDataSetChanged()
    }

    var deleteBtn: ((NoteItem) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DictionaryAdapterHolder =
        DictionaryAdapterHolder(
            DictionareyItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false

            )
        )


    override fun onBindViewHolder(holder: DictionaryAdapterHolder, position: Int) {
        holder.bindData(data = data[position])
        holder.binding.dictionaryDelete.setOnClickListener {
            deleteBtn?.invoke(data[position])
        }
    }


    override fun getItemCount(): Int = data.size
}
