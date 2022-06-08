package com.pfa.sudodental.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginController {
    @GetMapping("/Login")
    public String login(){
        return "login";
    }
}
