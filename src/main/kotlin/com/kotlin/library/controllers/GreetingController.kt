package com.kotlin.library.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import java.sql.Timestamp
import java.time.format.DateTimeFormatter
import java.time.*
import java.util.*
import org.springframework.beans.factory.annotation.Autowired
import com.kotlin.library.utils.DateUtils


@RestController
class GreetingController(val messageSource: MessageSource) {

    @Autowired
    lateinit var dateUtils: DateUtils

    @GetMapping("/greeting")
    fun getGreeting(): String {
        return messageSource.getMessage("greeting", null, LocaleContextHolder.getLocale())
    }

    @GetMapping("/formatted-date-time-str")
    fun getFormattedDateTimeStr(): String {
        return dateUtils.currentDateTimeStr()
    }

    @GetMapping("/formatted-date-time")
    fun getFormattedDateTime(): Timestamp {
        return dateUtils.currentDateTime()
    }

    @GetMapping("/formatted-date-str")
    fun getFormattedDateStr(): String {
        return dateUtils.currentDateStr()
    }

    @GetMapping("/formatted-date")
    fun getFormattedDate(): Date {
        return dateUtils.currentDate()
    }
}