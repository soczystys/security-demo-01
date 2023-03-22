package com.demos.securitydemo01.controller;

import com.demos.securitydemo01.model.Customer;
import com.demos.securitydemo01.model.CustomerDto;
import com.demos.securitydemo01.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String hello() {
        System.out.println("hello");
        return "hello";
    }

    @GetMapping("/secure")
    public String secure() {
        return "secure";
    }

//    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public ResponseEntity<Customer> register(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setEmail(customerDto.getEmail());
        customer.setPwd(passwordEncoder.encode(customerDto.getPwd()));
        customer.setRole("USER");
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
    }


}