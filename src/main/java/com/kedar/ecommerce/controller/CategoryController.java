package com.kedar.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @GetMapping("/sample")
    public String helloWorld(){
        return "Hello World";
    }

}
