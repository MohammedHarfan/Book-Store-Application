package com.store.service.Impl;

import com.store.BookStoreApplication;
import com.store.model.Book;
import com.store.repository.BookRepository;
import com.store.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookStoreApplication.class)
class BookServiceImplTest {
    @Autowired
    public BookService bookService;
    @MockBean
    private BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        bookService = new BookServiceImpl(bookRepository);
    }

    @Test
    public void saveBook() {
        bookService.saveBook("Book", "its a book", "author boooks", 100.0);
    }
}