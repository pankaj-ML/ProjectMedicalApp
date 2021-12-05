package com.App

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.EnableMongoAuditing



@EnableMongoAuditing
@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
@EnableEurekaClient
@EnableFeignClients
@Configuration
@EnableAutoConfiguration
class MedicalAppApplication

fun main(args: Array<String>) {
    runApplication<MedicalAppApplication>(*args)
}