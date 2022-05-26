package com.store.service;

import com.store.BookStoreApplication;
import com.store.model.Purchase;
import com.store.repository.PurchaseHistoryRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookStoreApplication.class)
public class PurchaseHistoryServiceTest {

    @Autowired
    PurchaseHistoryService purchaseHistoryService;

    @Autowired
    PurchaseHistoryRepository purchaseHistoryRepository;

    @Test
    public void savePurchase() {
        Purchase purchaseHistory = new Purchase();
        purchaseHistory.setUserId(2L);
//        purchaseHistory.setBookId(3L);
        purchaseHistory.setPrice(120.22);
        Purchase actual = purchaseHistoryService.savePurchaseHistory(purchaseHistory);
        assertThat(actual.getUserId()).isEqualTo(2);
    }

    @Test
    public void findAllPurchase() {
        purchaseHistoryService.findAllPurchaseByUser(11L);
    }
}