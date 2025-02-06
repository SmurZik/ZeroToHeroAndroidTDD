package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class TextAdapter : RecyclerView.Adapter<TextViewHolder>() {

    private val list = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TextViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.element_text_view, parent, false)
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun save(bundle: Bundle) {
        bundle.putStringArrayList("key", ArrayList(list))
    }

    fun restore(bundle: Bundle) {
        list.clear()
        list.addAll(bundle.getStringArrayList("key")?.toMutableList() ?: mutableListOf())
        notifyItemRangeInserted(0, list.size)
    }

    fun map(source: String) {
        list.add(source)
        notifyItemInserted(list.size - 1)
    }

}

class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textView = view.findViewById<TextView>(R.id.elementTextView)

    fun bind(text: String) {
        textView.text = text
    }
}