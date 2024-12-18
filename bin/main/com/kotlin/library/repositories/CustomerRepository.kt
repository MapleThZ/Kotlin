package com.kotlin.library.repositories

import org.springframework.data.jpa.repository.JpaRepository
import com.kotlin.library.entities.Customer

interface CustomerRepository : JpaRepository<Customer, Long> {
    fun findByfirstName(firstName: String): Customer?
    fun findById(id: String): Customer?
}