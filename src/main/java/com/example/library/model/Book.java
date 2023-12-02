package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;
    private String publisher;
    private String language;
    private String description;
    @ElementCollection
    private List<String> genres;
    private String imageName;


}
