package ru.easycode.zerotoheroandroidtdd.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ListElementBinding

class ListAdapter : RecyclerView.Adapter<ListViewHolder>() {

    private val itemList = mutableListOf<CharSequence>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder =
        ListViewHolder(ListElementBinding.inflate(LayoutInflater.from(parent.context)))

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun update(source: List<CharSequence>) {
        val diffUtil = DiffUtilCallback(itemList, source)
        val diff = DiffUtil.calculateDiff(diffUtil)
        itemList.clear()
        itemList.addAll(source)
        diff.dispatchUpdatesTo(this)
    }
}

class ListViewHolder(private val binding: ListElementBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(text: CharSequence) {
        binding.elementTextView.text = text
    }
}

class DiffUtilCallback(
    private val oldList: List<CharSequence>,
    private val newList: List<CharSequence>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

}