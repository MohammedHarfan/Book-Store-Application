package com.store.controller;

import com.store.model.Purchase;
import com.store.security.UserPrincipal;
import com.store.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PurchaseController {
    private PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> savePurchaseHistory(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.savePurchaseHistory(purchase), HttpStatus.CREATED);
    }

    @GetMapping("/purchases")
    public ResponseEntity<?> getAllPurchasesOfUser(@AuthenticationPrincipal UserPrincipal userPrincipal) {
        return ResponseEntity.ok(purchaseService.findAllPurchaseByUser(userPrincipal.getId()));
    }
}
