package com.kotlin.library.models

import kotlinx.serialization.Serializable

@Serializable
data class MessagePost (
    val name:String,
    val lastname:String,
    val telno: Int
    )