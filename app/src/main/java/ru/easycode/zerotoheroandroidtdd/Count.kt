package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun initial(number: String): UiState

    fun increment(number: String): UiState

    fun decrement(number: String): UiState

    class Base(
        private val step: Int,
        private val max: Int,
        private val min: Int
    ) : Count {

        init {
            if (step <= 0) throw IllegalStateException("step should be positive, but was $step")
            if (max <= 0) throw IllegalStateException("max should be positive, but was $max")
            if (max < step) throw IllegalStateException("max should be more than step")
            if (max <= min) throw IllegalStateException("max should be more than min")
        }

        override fun initial(number: String): UiState {
            return if (number.toInt() <= min) UiState.Min(text = number)
            else if (number.toInt() >= max) UiState.Max(text = number)
            else return UiState.Base(text = number)
        }

        override fun increment(number: String): UiState {
            val result = number.toInt() + step
            return if (result + step > max) UiState.Max(text = result.toString())
            else UiState.Base(text = result.toString())

        }

        override fun decrement(number: String): UiState {
            val result = number.toInt() - step
            return if (result - step < min) UiState.Min(text = result.toString())
            else UiState.Base(text = result.toString())
        }
    }
}