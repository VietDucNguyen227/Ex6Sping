package com.example.ex6springboot.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "index","/home"})
    public String showIndex(){
        return "index"; //ten view = ten cua file HTML
    }

}
