package com.example.cmatask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/students")
    public String root(){
        return "index.html";
    }
}
