package com.challenge.sophosapp.data.models.response

import com.google.gson.annotations.SerializedName

data class OfficesResponseModel(
    @SerializedName("Items")
    val items: List<OfficeModel> = emptyList(),
    @SerializedName("Count")
    val count: Int? = null,
    @SerializedName("ScannedCount")
    val scannedCount: Int? = null
)
