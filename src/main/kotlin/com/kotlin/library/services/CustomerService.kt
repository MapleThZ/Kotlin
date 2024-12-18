package com.kotlin.library.services

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.kotlin.library.repositories.CustomerRepository
import com.kotlin.library.entities.Customer
import com.kotlin.library.models.CustomerRequest
import org.modelmapper.ModelMapper
import java.sql.Timestamp
import java.util.Date

@Service
class CustomerService (@Autowired private val customerRepository: CustomerRepository) {

    fun getUserByUsername(firstName: String): Customer? {
        return customerRepository.findByfirstName(firstName)
    }

    fun getUserById(id: Long): Customer? {
        var cusTemp : Customer = customerRepository.findById(id).get()
        return cusTemp
    }

    fun createUser(customerReq: CustomerRequest): Customer {

        var time: Timestamp = Timestamp(Date().time)

        val customer: Customer = Customer(customerReq.id,customerReq.firstName,customerReq.lastName,customerReq.telNo,customerReq.email,customerReq.id.toString(),time,customerReq.id.toString(),time)

        return customerRepository.save(customer)
    }
}