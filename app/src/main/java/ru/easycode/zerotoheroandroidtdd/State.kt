package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

interface State : Serializable {

    fun apply(layout: LinearLayout, textView: TextView, button: Button)

    object Initial : State {
        private fun readResolve(): Any = Initial
        override fun apply(layout: LinearLayout, textView: TextView, button: Button) = Unit
    }

    object Clicked : State {
        private fun readResolve(): Any = Clicked
        override fun apply(layout: LinearLayout, textView: TextView, button: Button) {
            layout.removeView(textView)
            button.isEnabled = false
        }
    }
}