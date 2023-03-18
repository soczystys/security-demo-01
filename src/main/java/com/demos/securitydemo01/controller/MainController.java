package com.demos.securitydemo01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/secure")
    public String secure() {
        return "secure";
    }


}