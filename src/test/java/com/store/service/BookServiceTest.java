package com.store.service;

import com.store.BookStoreApplication;
import com.store.model.Book;
import com.store.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookStoreApplication.class)
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void saveBook() {
        Book book = new Book();
        book.setTitle("Just book");
        book.setDescription("life of a book");
        book.setAuthor("Mr.Book");
        book.setPrice(100.00);
        Book actual = bookService.saveBook(book);
        assertEquals("Mr.Book", actual.getAuthor());
    }

    @Test
    public void deleteBook() {
        Book book = new Book();
        book.setTitle("Just book");
        book.setDescription("life of a book");
        book.setAuthor("Mr.Book");
        book.setPrice(100.00);
        bookRepository.save(book);
        bookService.deleteBook(book.getId());
        assertThat(bookRepository.findById(book.getId())).isEqualTo(Optional.empty());
    }

    @Test
    public void findAllBooks() {
        List<Book> actual = bookService.findAllBooks();
        assertThat(actual).isNotNull();
    }
}