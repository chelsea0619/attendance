package com.example.attendance_system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.Locale;

@RestController
public class helloController {
    @GetMapping("/hello")
    public String sayHello(){
        return "hello world";
    }


}
