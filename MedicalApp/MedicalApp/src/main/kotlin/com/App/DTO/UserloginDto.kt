package com.App.DTO

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

class UserloginDto
{
    @field:NotBlank(message = "Email field is mandatory")
    @field:Email(message = "Email field is Invalid")
    var email =""
    @field:NotBlank(message = "Password field is mandatory")
    var password =""

}