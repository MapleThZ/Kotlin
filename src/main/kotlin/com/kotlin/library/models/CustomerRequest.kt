package com.kotlin.library.models

import kotlinx.serialization.Serializable

@Serializable
data class CustomerRequest (
    val id: Long,
    val firstName : String,
    val lastName:String,
    val telNo:Long,
    val email:String
    ) 