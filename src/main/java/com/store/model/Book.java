package com.store.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", unique = true, nullable = false, length = 100)
    private String title;

    @Column(name = "description", unique = true, nullable = false, length = 100)
    private String description;

    @Column(name = "author", unique = true, nullable = false, length = 100)
    private String author;

    @Column(name = "price", unique = true, nullable = false)
    private Double price;

    @Column(name = "create_time", unique = true, nullable = false)
    private LocalDateTime createdTime;
}
