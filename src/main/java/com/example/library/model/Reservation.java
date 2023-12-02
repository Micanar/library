package com.example.library.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Users user;

    private Date startReservation;
    private Date endReservation;
}
