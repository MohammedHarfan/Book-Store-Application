package com.store.service;

import com.store.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Book saveBook(String title, String description, String author, Double price);

    void deleteBook(Long id);

    List<Book> findAllBooks();
}
