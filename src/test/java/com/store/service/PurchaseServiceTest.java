package com.store.service;

import com.store.BookStoreApplication;
import com.store.model.Book;
import com.store.model.Purchase;
import com.store.repository.BookRepository;
import com.store.repository.PurchaseRepository;
import com.store.repository.projection.PurchaseItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookStoreApplication.class)
public class PurchaseServiceTest {

    @Autowired
    PurchaseService purchaseService;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    BookRepository bookRepository;


    @Test
    public void savePurchase() {
        Purchase purchase = new Purchase();
        purchase.setUserId(2L);
        purchase.setBookId(3L);
        purchase.setPrice(120.22);
        purchase.setPurchaseTime(LocalDateTime.now());
        Purchase actual = purchaseService.savePurchaseHistory(purchase);
        assertThat(actual.getUserId()).isEqualTo(2);
    }

    @Test
    public void findAllPurchase() {
        Purchase purchase = new Purchase();
        purchase.setUserId(2L);
        purchase.setBookId(1L);
        purchase.setPrice(120.22);
        purchaseRepository.save(purchase);
        Book book = new Book();
        book.setTitle("Just book");
        book.setDescription("life of a book");
        book.setAuthor("Mr.Book");
        book.setPrice(100.0);
        bookRepository.save(book);
        List<PurchaseItem> actual = purchaseService.findAllPurchaseByUser(2L);
        assertThat(actual).isNotNull();
    }
}