package ru.easycode.zerotoheroandroidtdd.create

import android.view.LayoutInflater
import android.view.ViewGroup
import ru.easycode.zerotoheroandroidtdd.core.AbstractFragment
import ru.easycode.zerotoheroandroidtdd.databinding.CreateLayoutBinding

class CreateFragment : AbstractFragment<CreateLayoutBinding>() {

    override fun bind(inflater: LayoutInflater, container: ViewGroup?): CreateLayoutBinding {
        return CreateLayoutBinding.inflate(inflater, container, false)
    }
}