package com.kotlin.library.controllers

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.kotlin.library.services.CustomerService
import com.kotlin.library.entities.Customer
import com.kotlin.library.models.CustomerRequest
import com.kotlin.library.models.CustomerResponse
import java.util.*
import org.springframework.http.ResponseEntity


@RestController
@RequestMapping("/api")
class CustomerController() {

    @Autowired 
    lateinit var customerService: CustomerService

    @GetMapping("/findByFirstName")
    fun findByFirstName(firstName: String): ResponseEntity<List<CustomerResponse>> {
        return ResponseEntity.ok(customerService.getUserByUsername(firstName))
    }

    @GetMapping("/findById")
    fun findById(idNo:String): ResponseEntity<CustomerResponse>  {
        return ResponseEntity.ok(customerService.getUserById(idNo))
    }

    @PostMapping("/createUser", headers = ["Authorization"])
    fun createUser(@RequestBody customerReq: CustomerRequest):  ResponseEntity<CustomerResponse> {
        return ResponseEntity.ok(customerService.createUser(customerReq))
    }
}