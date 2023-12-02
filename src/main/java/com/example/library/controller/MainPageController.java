package com.example.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/main")
    public String mainPage(Model model){
        model.addAttribute("message","Привет, это главная страница");
        return "main";
    }
}
