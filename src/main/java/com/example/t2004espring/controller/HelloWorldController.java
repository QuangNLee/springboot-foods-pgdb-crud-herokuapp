package com.example.t2004espring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller
public class HelloWorldController {
    @GetMapping("hello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("goodbye")
    public String sayGoodbye(){
        return "Good Bye!";
    }

    @GetMapping("demo")
    public String demo(){
        return "Demo Spring";
    }
}
