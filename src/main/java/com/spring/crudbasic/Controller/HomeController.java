package com.spring.crudbasic.Controller;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class HomeController {

    @GetMapping("/")
    public String Hometest() {
        return  "CRUD-Application";
    }

}
