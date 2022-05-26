package com.store.service.Impl;

import com.store.model.Purchase;
import com.store.repository.PurchaseHistoryRepository;
import com.store.service.PurchaseHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {

    private PurchaseHistoryRepository purchaseHistoryRepository;

    private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    public PurchaseHistoryServiceImpl(PurchaseHistoryRepository purchaseHistoryRepository) {
        this.purchaseHistoryRepository = purchaseHistoryRepository;
    }

    @Override
    public Purchase savePurchaseHistory(Purchase purchase) {
        purchase.setPurchaseTime(LocalDateTime.now());
        purchaseHistoryRepository.save(purchase);
        logger.info("PurchaseHistory saved with Id {}", purchase.getId());
        return purchase;
    }

    @Override
    public List<Purchase> findAllPurchaseByUser(Long user_Id) {
        List<Purchase> purchaseHistory = purchaseHistoryRepository.findAllPurchaseOfUser(user_Id);
        logger.info("Fetched all purchase by user {}", user_Id);
        return purchaseHistory;
    }
}
