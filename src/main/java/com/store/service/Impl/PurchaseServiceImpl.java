package com.store.service.Impl;

import com.store.model.Purchase;
import com.store.repository.PurchaseRepository;
import com.store.repository.projection.PurchaseItem;
import com.store.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private PurchaseRepository purchaseRepository;

    private static Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);

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
    public List<PurchaseItem> findAllPurchaseByUser(Long userId) {
        logger.info("Purchase by user for id {}", userId);
        return purchaseRepository.findAllPurchaseOfUser(userId);
    }
}
