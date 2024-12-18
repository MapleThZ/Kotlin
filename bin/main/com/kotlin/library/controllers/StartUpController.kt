package com.kotlin.library.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import com.kotlin.library.services.LibraryService
import com.kotlin.library.services.LibraryServiceTemp2
import com.kotlin.library.models.requests.MessagePost


@RestController
class LibraryController(private val libraryService: LibraryService,private val libraryServiceTemp2: LibraryServiceTemp2) {

    @GetMapping("/message")
    fun getMessage(name: String): String {
        return libraryService.getMessage(name)
    }

    @GetMapping("/message2")
    fun getMessage2(): String {
        return libraryServiceTemp2.getMessage()
    }

    @PostMapping("/message")
    fun PostMapping(post: MessagePost): String {
        return libraryService.getMessage(post)
    }

    @PostMapping("/messageObject")
    fun PostMappingObject(post: MessagePost): MessagePost {
        return libraryService.getMessageObject(post)
    }
}