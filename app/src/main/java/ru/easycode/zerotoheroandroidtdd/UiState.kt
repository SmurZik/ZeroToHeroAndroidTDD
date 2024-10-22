package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(textView: TextView, button: Button, progressBar: ProgressBar)

    object Initial : UiState {
        override fun apply(textView: TextView, button: Button, progressBar: ProgressBar) {
            textView.visibility = View.INVISIBLE
            progressBar.visibility = View.INVISIBLE
            button.isEnabled = true
        }
    }

    object Clicked : UiState {
        override fun apply(textView: TextView, button: Button, progressBar: ProgressBar) {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
        }
    }

    object Finish : UiState {
        override fun apply(textView: TextView, button: Button, progressBar: ProgressBar) {
            button.isEnabled = true
            progressBar.visibility = View.INVISIBLE
            textView.visibility = View.VISIBLE
        }
    }
}