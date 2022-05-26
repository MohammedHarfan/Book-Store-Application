package com.store.service.Impl;

import com.store.model.Purchase;
import com.store.repository.PurchaseRepository;
import com.store.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private PurchaseRepository purchaseRepository;

    private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public Purchase savePurchaseHistory(Purchase purchase) {
        purchase.setPurchaseTime(LocalDateTime.now());
        purchaseRepository.save(purchase);
        logger.info("PurchaseHistory saved with Id {}", purchase.getId());
        return purchase;
    }

    @Override
    public List<Purchase> findAllPurchaseByUser(Long user_Id) {
        List<Purchase> purchaseHistory = purchaseRepository.findAllPurchaseOfUser(user_Id);
        logger.info("Fetched all purchase by user {}", user_Id);
        return purchaseHistory;
       // return null;
    }
}
