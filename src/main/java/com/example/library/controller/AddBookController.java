package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class AddBookController {


    private  String uploadPath="C:/Users/user/OneDrive/Desktop/library/src/main/resources/static/img";

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
        if (image!=null) {
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String fileName=UUID.randomUUID().toString();
            fileName = fileName  + image.getOriginalFilename();
            book.setImageName(fileName);
            image.transferTo(new File(uploadPath + "/"+fileName));


            System.out.println(uploadPath);
        }
        bookRepository.save(book);
        return "bookAdd";
    }
}
