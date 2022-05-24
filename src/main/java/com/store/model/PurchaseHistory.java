package com.store.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "purchase_history")
public class PurchaseHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", unique = true, nullable = false)
    private Long userId;

    @Column(name = "book_id", unique = true, nullable = false)
    private Long bookId;

    @Column(name = "price", unique = true, nullable = false)
    private Double price;

    @Column(name = "purchase_time", unique = true, nullable = false)
    private LocalDateTime purchaseTime;
}
