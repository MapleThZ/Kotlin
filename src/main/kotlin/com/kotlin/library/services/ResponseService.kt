package com.kotlin.library.services

import org.springframework.stereotype.Service

@Service
class ResponseService {

    fun getResponseMessage(): String {
        return "Status: "
    }
}