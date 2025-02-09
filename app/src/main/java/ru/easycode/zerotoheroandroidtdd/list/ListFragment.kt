package ru.easycode.zerotoheroandroidtdd.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.easycode.zerotoheroandroidtdd.core.AbstractFragment
import ru.easycode.zerotoheroandroidtdd.core.ProvideViewModel
import ru.easycode.zerotoheroandroidtdd.databinding.ListLayoutBinding

class ListFragment : AbstractFragment<ListLayoutBinding>() {

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): ListLayoutBinding {
        return ListLayoutBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = (activity as ProvideViewModel).viewModel(ListViewModel::class.java)

        binding.addButton.setOnClickListener {
            viewModel.create()
        }
    }
}