package com.challenge.sophosapp.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.challenge.sophosapp.core.DocumentConverterHelper
import com.challenge.sophosapp.databinding.FragmentImagePreviewBinding
import com.challenge.sophosapp.domain.definitions.Constants.DOCUMENT_DETAIL

class ImagePreviewFragment : Fragment() {
    private var _binding: FragmentImagePreviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentImagePreviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(DOCUMENT_DETAIL)?.let {
            initialize(it)
        }
    }

    private fun initialize(image: String) {
        binding.DocumentPreviewImageView.setImageBitmap(DocumentConverterHelper.decodeFromBase64(image))
    }
}
