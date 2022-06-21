package com.store.service;

import com.store.model.Purchase;
import com.store.repository.projection.PurchaseItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseService {
    Purchase savePurchaseHistory(Purchase purchase);

    List<PurchaseItem> findAllPurchaseByUser(Long userId);
}
