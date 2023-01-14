package com.challenge.sophosapp.data.models.response

import com.google.gson.annotations.SerializedName

class DocumentsUploadResponseModel {
    @SerializedName("put")
    var uploaded: Boolean = false
}
