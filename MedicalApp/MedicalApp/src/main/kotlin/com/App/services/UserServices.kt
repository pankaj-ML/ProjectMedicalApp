package com.App.services

import com.App.DTO.UserRegistrationDto
import com.App.model.User
import org.springframework.data.annotation.Id
import org.springframework.http.ResponseEntity
import java.util.*


interface UserServices  {
    fun signUp( user: User): User
    fun login(user: User): User?
    fun findbyEmail( Email: String) : User?
    fun updatebyID(id: Long, user: User): User
    fun getAllUsers():List<User>
    fun getUserbyID(id: Long): Optional<User>?
    fun deletbyID(id: Long)
    fun deletAll()












}