package com.kotlin.library.services

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.kotlin.library.repositories.CustomerRepository
import com.kotlin.library.entities.Customer
import com.kotlin.library.models.CustomerRequest
import org.modelmapper.ModelMapper

@Service
class CustomerService (@Autowired private val customerRepository: CustomerRepository) {

    fun getUserByUsername(firstName: String): Customer? {
        return customerRepository.findByfirstName(firstName)
    }

    fun getUserById(id: Long): Customer? {
        return customerRepository.getReferenceById(id)
    }

    fun createUser(customerReq: CustomerRequest): Customer {

        val modelMapper = ModelMapper()

        val customer = modelMapper.map(customerReq, Customer::class.java)

        return customerRepository.save(customer)
    }
}