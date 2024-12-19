package com.kotlin.library.models

data class ResponseModel(
    var responseCode: String,
    var responseMessage: String,
    var data: Object,
    var exception: Object
)