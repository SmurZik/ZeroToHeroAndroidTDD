package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ElementTextViewBinding


class ItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    private val itemList = ArrayList<CharSequence>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ElementTextViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun update(source: ArrayList<CharSequence>) {
        val diff = DiffUtilCallback(itemList, source)
        val result = DiffUtil.calculateDiff(diff)
        itemList.clear()
        itemList.addAll(source)
        result.dispatchUpdatesTo(this)
    }

}

class ItemViewHolder(private val binding: ElementTextViewBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(text: CharSequence) {
        binding.root.text = text
    }
}

class DiffUtilCallback(
    private val oldList: ArrayList<CharSequence>,
    private val newList: ArrayList<CharSequence>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]

}