package com.store.service.Impl;

import com.store.model.Book;
import com.store.repository.BookRepository;
import com.store.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Override
    public Book saveBook(Book book) {
        book.setCreatedTime(LocalDateTime.now());
        bookRepository.save(book);
        logger.info("Book has saved in ID {}", book.getId());
        return book;
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
        logger.info("Book has deleted for ID {}", id);
    }

    @Override
    public List<Book> findAllBooks() {
        List<Book> book = bookRepository.findAll();
        logger.info("Fetched all values for book {}", book);
        return book;
    }
}
