package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {
    private final BookRepository bookRepository;

    public MainPageController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/main")
    public String mainPage(Model model){
        model.addAttribute("books",bookRepository.findAll());
        model.addAttribute("message","Привет, это главная страница");
        return "main";
    }
}
