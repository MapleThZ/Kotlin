package com.kotlin.library.models

import kotlinx.serialization.Serializable

@Serializable
data class CustomerResponse (
    var id: String = "",
    var firstName : String = "",
    var lastName:String = "",
    var telNo:String = "",
    var email:String = ""
    ) 