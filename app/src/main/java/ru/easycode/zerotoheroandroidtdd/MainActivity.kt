package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var state: UiState
    private val count = Count.Base(step = 2, max = 4, min = 0)
    private lateinit var textView: TextView
    private lateinit var buttonInc: Button
    private lateinit var buttonDec: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.countTextView)
        buttonInc = findViewById(R.id.incrementButton)
        buttonDec = findViewById(R.id.decrementButton)

        buttonInc.setOnClickListener {
            state = count.increment(textView.text.toString())
            state.apply(buttonInc, buttonDec, textView)
        }

        buttonDec.setOnClickListener {
            state = count.decrement(textView.text.toString())
            state.apply(buttonInc, buttonDec, textView)
        }

        if (savedInstanceState == null) {
            state = count.initial(textView.text.toString())
            state.apply(buttonInc, buttonDec, textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(KEY, UiState::class.java) as UiState
        } else {
            savedInstanceState.getSerializable(KEY) as UiState
        }
        state.apply(buttonInc, buttonDec, textView)
    }

    companion object {
        private const val KEY = "key"
    }
}