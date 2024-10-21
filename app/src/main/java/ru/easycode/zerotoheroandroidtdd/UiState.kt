package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(buttonInc: Button, buttonDec: Button, textView: TextView)

    data class Min(private val text: String) : UiState {
        override fun apply(buttonInc: Button, buttonDec: Button, textView: TextView) {
            buttonInc.isEnabled = true
            buttonDec.isEnabled = false
            textView.text = text
        }
    }

    data class Base(private val text: String) : UiState {
        override fun apply(buttonInc: Button, buttonDec: Button, textView: TextView) {
            buttonInc.isEnabled = true
            buttonDec.isEnabled = true
            textView.text = text
        }
    }

    data class Max(private val text: String) : UiState {
        override fun apply(buttonInc: Button, buttonDec: Button, textView: TextView) {
            buttonInc.isEnabled = false
            buttonDec.isEnabled = true
            textView.text = text
        }
    }
}