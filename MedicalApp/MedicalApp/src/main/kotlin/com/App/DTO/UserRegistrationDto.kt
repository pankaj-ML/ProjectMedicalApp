package com.App.DTO

import org.springframework.data.annotation.Id
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class UserRegistrationDto {



    @Id
    var id: Long? =null
    @field:NotBlank(message = "Name field is mandatory")
    var name: String? = null
    @field:NotBlank(message = "Designation field is mandatory")
    var designation: String? = null

    @field:NotBlank(message = "City field is mandatory")
    val city: String? =null

    @field:NotBlank(message = "Email field is mandatory")
    @field:Email(message = "Email is Not valid")
    var email: String? = null
    @field:NotBlank(message = "Password field is mandatory")
    var password: String? = null

}


