package com.kotlin.library.entities

import jakarta.persistence.*

@Entity
data class Customer (
    @Id
    val id: Long,
    @Column(name="first_name")
    val firstName : String,
    @Column(name="last_name")
    val lastName:String,
    @Column(name="tel_no")
    val telNo:Long,
    @Column(name="email")
    val email:String
    ) 