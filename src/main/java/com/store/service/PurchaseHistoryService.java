package com.store.service;

import com.store.model.PurchaseHistory;

import java.util.List;

public interface PurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<PurchaseHistory> findAllPurchaseByUser(Long userId);
}
