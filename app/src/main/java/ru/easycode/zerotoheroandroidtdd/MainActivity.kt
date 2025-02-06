package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var words = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        words = savedInstanceState?.getStringArrayList("key") ?: arrayListOf()
        words.forEach {
            addText(it, binding.contentLayout)
        }

        binding.actionButton.setOnClickListener {
            val text = binding.inputEditText.text.toString()
            addText(text, binding.contentLayout)
            words.add(text)
            binding.inputEditText.text?.clear()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList("key", words)
    }

    private fun addText(text: String, layout: LinearLayout) {
        val textView = TextView(this)
        textView.text = text
        layout.addView(textView)
    }
}