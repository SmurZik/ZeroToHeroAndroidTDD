package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TextAdapter : RecyclerView.Adapter<TextViewHolder>() {

    private val list = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TextViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.element_text_view, parent, false)
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun restore(source: List<String>) {
        list.clear()
        list.addAll(source)
        notifyDataSetChanged()
    }

    fun map(source: String) {
        list.add(source)
        notifyDataSetChanged()
    }

}

class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textView = view.findViewById<TextView>(R.id.elementTextView)

    fun bind(text: String) {
        textView.text = text
    }
}