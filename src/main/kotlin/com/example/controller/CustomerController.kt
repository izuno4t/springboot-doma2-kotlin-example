package com.example.controller

import com.example.entiry.Customer
import com.example.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customer")
class CustomerController(
    val service: CustomerService
) {

    @GetMapping("/", "")
    fun index(): ResponseEntity<List<Customer>> {
        val list = service.findAll()
        return ResponseEntity<List<Customer>>(list, HttpStatus.OK)
    }


}