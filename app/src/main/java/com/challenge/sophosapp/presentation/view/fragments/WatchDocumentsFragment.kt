package com.challenge.sophosapp.presentation.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.challenge.sophosapp.databinding.FragmentWatchDocumentsBinding
import com.challenge.sophosapp.domain.definitions.Constants.DOCUMENTS_INFO
import com.challenge.sophosapp.domain.managers.DocumentResourcesDataManager
import com.challenge.sophosapp.domain.models.DocumentGeneralInfoDto
import com.challenge.sophosapp.domain.models.DocumentsListDto
import com.challenge.sophosapp.presentation.view.adapters.DocumentListAdapter

class WatchDocumentsFragment :
    Fragment(),
    DocumentListAdapter.OnItemClickListener {

    interface WatchDocumentsFragmentListener {
        fun retrieveDocumentInfo(id: String)
    }

    private lateinit var adapterDocumentList: DocumentListAdapter
    private var _binding: FragmentWatchDocumentsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentWatchDocumentsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<DocumentsListDto>(DOCUMENTS_INFO)?.let {
            initialize(it)
        }
    }

    private fun initialize(documentsList: DocumentsListDto) {
        val documentResourcesDataManager = DocumentResourcesDataManager(requireContext().resources)
        adapterDocumentList = DocumentListAdapter(
            documentsList.itemList,
            this@WatchDocumentsFragment,
            documentResourcesDataManager
        )
        binding.contractsRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = adapterDocumentList
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(model: DocumentGeneralInfoDto) {
        (activity as WatchDocumentsFragmentListener).retrieveDocumentInfo(model.id)
    }
}
