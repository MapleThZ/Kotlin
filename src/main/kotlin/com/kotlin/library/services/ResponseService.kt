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
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@Service
class ResponseService<T>(
    body: T,
    status: HttpStatus) {
        
    val status: T? = responseEntity.statusCode
    val body: T? = responseEntity.body

    fun getResponseMessage(): String {
        return "Status: $status, Additional Info: $additionalInfo"
    }
}