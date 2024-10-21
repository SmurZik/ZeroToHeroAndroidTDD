package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(button: Button, textView: TextView)

    data class Base(private val text: String) : UiState {
        override fun apply(button: Button, textView: TextView) {
            textView.text = text
        }
    }

    data class Max(private val text: String) : UiState {
        override fun apply(button: Button, textView: TextView) {
            textView.text = text
            button.isEnabled = false
        }
    }
}