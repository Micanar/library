package com.example.library.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;
    private Date dateOfBirth;
    private String phoneNumber;
    private String address;
}
