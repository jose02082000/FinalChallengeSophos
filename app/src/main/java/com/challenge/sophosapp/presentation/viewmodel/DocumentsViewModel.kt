package com.challenge.sophosapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.challenge.sophosapp.data.models.request.PutDocumentsRequestEntity
import com.challenge.sophosapp.data.models.response.DocumentsUploadResponseModel
import com.challenge.sophosapp.domain.models.DocumentDetailDto
import com.challenge.sophosapp.domain.models.DocumentsListDto
import com.challenge.sophosapp.domain.usecase.GetDocumentDetailUseCase
import com.challenge.sophosapp.domain.usecase.GetDocumentsListUseCase
import kotlinx.coroutines.launch
import com.challenge.sophosapp.domain.usecase.UploadDocumentsUseCase

class DocumentsViewModel : ViewModel() {
    val putDocumentsModel = MutableLiveData<DocumentsUploadResponseModel>()
    val getDocumentsListModel = MutableLiveData<DocumentsListDto>()
    val getDocumentDetailModel = MutableLiveData<DocumentDetailDto>()
    val isLoading = MutableLiveData<Boolean>()
    private val uploadDocumentsUseCase = UploadDocumentsUseCase()
    private val getDocumentsListUseCase = GetDocumentsListUseCase()
    private val getDocumentDetailUseCase = GetDocumentDetailUseCase()

    fun putImageToRemote(params: PutDocumentsRequestEntity) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = uploadDocumentsUseCase.invoke(params)
            putDocumentsModel.postValue(result)
            isLoading.postValue(false)
        }
    }

    fun getUploadedImagesList(email: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getDocumentsListUseCase.invoke(email)
            getDocumentsListModel.postValue(result)
            isLoading.postValue(false)
        }
    }

    fun getImageDetail(id: String) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getDocumentDetailUseCase.invoke(id)
            getDocumentDetailModel.postValue(result)
            isLoading.postValue(false)
        }
    }
}
