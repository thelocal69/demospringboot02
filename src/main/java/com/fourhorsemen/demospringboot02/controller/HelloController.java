package com.fourhorsemen.demospringboot02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController{

    @GetMapping("")
    public String hello(){
        return "hello springboot";
    }

    @GetMapping("/cybersoft")
    public String helloCybersoft(){
        return "hello cybersoft";
    }
}
