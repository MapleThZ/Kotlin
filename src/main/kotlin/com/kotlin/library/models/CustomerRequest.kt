package com.kotlin.library.models

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import kotlinx.serialization.Serializable

@Serializable
data class CustomerRequest (
    @field:NotBlank(message = "Name cannot be empty")
    val id: String,
    val firstName : String,
    val lastName:String,
    val telNo:String,
    @field:Email(message = "Invalid email format")
    val email:String
    ) 