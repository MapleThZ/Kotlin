package com.kotlin.library.models

import kotlinx.serialization.Serializable

@Serializable
data class CustomerRequest (
    val id: String,
    val firstName : String,
    val lastName:String,
    val telNo:String,
    val email:String
    ) 