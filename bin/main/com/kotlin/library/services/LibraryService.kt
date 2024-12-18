package com.kotlin.library.services

import org.springframework.stereotype.Service
import com.kotlin.library.models.requests.MessagePost

import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

@Service
class LibraryService {

    fun getMessage(name :String): String {
        return "Hello from the Spring Boot Kotlin Library! = "+ name
    }

    fun getMessage(post :MessagePost): String {
        val jsonString = Json.encodeToString(post)
        return "Hello from the Spring Boot Kotlin Library! = "+ jsonString
    }

    fun getMessageObject(post :MessagePost): MessagePost {
        return post
    }
}