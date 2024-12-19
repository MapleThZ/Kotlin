package com.kotlin.library.repositories

import org.springframework.data.jpa.repository.JpaRepository
import com.kotlin.library.entities.Customer
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CustomerRepository : JpaRepository<Customer, String> {
    fun findByfirstName(firstName: String): Optional<List<Customer>>
}