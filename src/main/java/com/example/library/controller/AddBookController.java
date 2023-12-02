package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class AddBookController {

    private  final BookRepository bookRepository;

    @Autowired
    public AddBookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/add-book")
    public String addBooks(){
        return "bookAdd";
    }
    @PostMapping("/add")
    public String addBook( @RequestParam String name,
                           @RequestParam String author,
                           @RequestParam String publisher,
                           @RequestParam String language,
                           @RequestParam String description,
                           @RequestParam("genre") List<String> genres,
                           @RequestParam("image") MultipartFile image
    ) throws IOException {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setDescription(description);
        book.setPublisher(publisher);
        book.setLanguage(language);
        book.setGenres(genres);
        book.setImageName(image.getOriginalFilename());
        bookRepository.save(book);
        return "bookAdd";
    }
}
