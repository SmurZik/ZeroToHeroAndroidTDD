package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ListLiveDataWrapper {

    fun liveData(): LiveData<List<CharSequence>>

    fun add(new: CharSequence)

    fun save(bundle: BundleWrapper.Save)

    fun update(list: List<CharSequence>)

    class Base(
        private val liveData: MutableLiveData<List<CharSequence>> = SingleLiveEvent()
    ) : ListLiveDataWrapper {

        override fun liveData() = liveData

        override fun add(new: CharSequence) {
            val oldList = liveData.value?.toMutableList() ?: mutableListOf()
            oldList.add(new)
            update(oldList)
        }

        override fun save(bundle: BundleWrapper.Save) {
            bundle.save(liveData.value?.let { ArrayList(it) } ?: ArrayList())
        }

        override fun update(list: List<CharSequence>) {
            liveData.value = list
        }
    }
}