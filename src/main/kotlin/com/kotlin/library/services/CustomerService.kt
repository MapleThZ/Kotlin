package com.kotlin.library.services

import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import com.kotlin.library.repositories.CustomerRepository
import com.kotlin.library.entities.Customer
import com.kotlin.library.models.CustomerRequest
import com.kotlin.library.models.CustomerResponse
import org.modelmapper.ModelMapper
import java.sql.Timestamp
import java.util.*
import java.time.*
import com.kotlin.library.utils.DateUtils
import org.apache.commons.lang3.StringUtils
import org.apache.commons.beanutils.BeanUtils

@Service
class CustomerService () {  

    @Autowired 
    lateinit var customerRepository: CustomerRepository

    @Autowired
    lateinit var dateUtils: DateUtils

    fun getUserByUsername(firstName: String): List<CustomerResponse> {
        val customerOpt = customerRepository.findByfirstName(firstName)
        var customers = ArrayList<CustomerResponse>();

        if(customerOpt.isPresent()){
            for ((index, customer) in customerOpt.get().withIndex()) {
                var customerRes = CustomerResponse();
                BeanUtils.copyProperties(customerRes, customer)
                customers.add(customerRes)
            }
        }

        return customers
    }

    fun getUserById(idNo: String): CustomerResponse {
        var customer = customerRepository.findById(idNo)
        var customerRes = CustomerResponse();

        if(customer.isPresent()){
            BeanUtils.copyProperties(customerRes, customer.get())
        }

        return customerRes
    }

    fun createUser(customerReq: CustomerRequest): CustomerResponse {

        var time: Timestamp = dateUtils.currentDateTime()

        val customer: Customer = Customer(customerReq.id,customerReq.firstName,customerReq.lastName,customerReq.telNo,customerReq.email,customerReq.id.toString(),time,customerReq.id.toString(),time)

        customerRepository.save(customer)

        return getUserById(customerReq.id)
    }
}