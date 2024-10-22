package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var state: UiState = UiState.Initial
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.actionButton)
        val textView = findViewById<TextView>(R.id.titleTextView)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        if (savedInstanceState == null) {
            state.apply(textView, button, progressBar)
        }

        button.setOnClickListener {
            state = UiState.Clicked
            state.apply(textView, button, progressBar)
            button.postDelayed({
                state = UiState.Finish
                state.apply(textView, button, progressBar)
            }, 3000)
        }
    }
}