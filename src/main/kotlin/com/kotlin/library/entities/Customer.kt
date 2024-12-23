package com.kotlin.library.entities

import jakarta.persistence.*
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.sql.Timestamp
import java.util.Date

@Entity
@Table(name = "customer" , schema = "demo")
data class Customer (
    @Id
    @NotNull
    @NotEmpty
    val id: String = "",
    @Column(name="first_name")
    val firstName : String = "",
    @Column(name="last_name")
    val lastName:String = "",
    @Column(name="tel_no")
    val telNo:String = "",
    @Column(name="email")
    val email:String = "",
    @Column(name="create_name")
    val createName:String = "",
    @Column(name="create_date")
    val createDate:Timestamp = Timestamp(Date().time),
    @Column(name="update_name")
    val updateName:String = "",
    @Column(name="update_date")
    val updateDate:Timestamp = Timestamp(Date().time)
    ) 