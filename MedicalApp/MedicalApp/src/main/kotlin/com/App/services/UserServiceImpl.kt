package com.App.services

import com.App.model.User
import com.App.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl:UserServices {
    @Autowired
    private lateinit var userRepository :UserRepository

    override fun signUp(user: User): User {
      return userRepository.save(user)
    }

    override fun login(user: User): User? {
        return userRepository.save(user)
    }



    override fun getAllUsers(): List<User> {
        return (this.userRepository.findAll())
    }

    override fun getUserbyID(id: Long): Optional<User> {
        return (this.userRepository.findById(id))
    }

    override fun deletbyID(id: Long) {
        this.userRepository.deleteById(id)

    }

    override fun deletAll() {
        this.userRepository.deleteAll()
    }

    override fun updatebyID(id: Long, user: User): User {
        var oldUser = this.userRepository.findById(id).orElse(null)
        oldUser.id = user.id
        oldUser.name=user.name
        oldUser.email=user.email
        oldUser.password=user.password
        oldUser.designation=user.designation
        return (this.userRepository.save(user))
    }


    override fun findbyEmail(email: String): User? {
        return (this.userRepository.findbyEmail(email))
    }


}