package com.kotlin.library.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import com.kotlin.library.services.LibraryService
import com.kotlin.library.services.LibraryServiceTemp2
import com.kotlin.library.services.CustomerService
import com.kotlin.library.models.MessagePost
import com.kotlin.library.entities.Customer
import com.kotlin.library.models.CustomerRequest


@RestController
class CustomerController(private val customerService: CustomerService) {

    @GetMapping("/findByFirstName")
    fun findByFirstName(firstName: String): Customer? {
        return customerService.getUserByUsername(firstName)
    }

    @GetMapping("/findById")
    fun findById(id:Long): Customer? {
        return customerService.getUserById(id)
    }

    @PostMapping("/createUser")
    fun createUser(customerReq: CustomerRequest): Customer? {
        return customerService.createUser(customerReq)
    }
}