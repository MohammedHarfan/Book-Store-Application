package com.store.service;

import com.store.model.Purchase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseHistoryService {
    Purchase savePurchaseHistory(Purchase purchase);

    List<Purchase> findAllPurchaseByUser(Long userId);
}
