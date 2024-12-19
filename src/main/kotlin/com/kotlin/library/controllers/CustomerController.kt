package com.kotlin.library.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.kotlin.library.services.CustomerService
import com.kotlin.library.entities.Customer
import com.kotlin.library.models.CustomerRequest
import com.kotlin.library.models.CustomerResponse
import java.util.*


@RestController
@RequestMapping("/api")
class CustomerController() {

    @Autowired 
    lateinit var customerService: CustomerService

    @GetMapping("/findByFirstName")
    fun findByFirstName(firstName: String): List<CustomerResponse> {
        return customerService.getUserByUsername(firstName)
    }

    @GetMapping("/findById")
    fun findById(idNo:String): CustomerResponse {
        return customerService.getUserById(idNo)
    }

    @PostMapping("/createUser")
    fun createUser(@RequestBody customerReq: CustomerRequest): CustomerResponse {
        return customerService.createUser(customerReq)
    }
}