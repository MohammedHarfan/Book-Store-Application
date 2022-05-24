package com.store.service.Impl;

import com.store.model.PurchaseHistory;
import com.store.repository.PurchaseHistoryRepository;
import com.store.service.PurchaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {

    private PurchaseHistoryRepository purchaseHistoryRepository;

    public PurchaseHistoryServiceImpl(PurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    @Override
    public PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory) {
        purchaseHistory.setPurchaseTime(LocalDateTime.now());
        return purchaseHistoryRepository.save(purchaseHistory);
    }

    @Override
    public List<PurchaseHistory> findAllPurchaseByUser(Long userId) {
        return purchaseHistoryRepository.findAllPurchaseOfUser(userId);
    }
}
