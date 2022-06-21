package com.store.repository;

import com.store.model.Purchase;
import com.store.repository.projection.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    @Query(value = "select b.title ,p.price ,p.purchaseTime from Purchase p left join Book b on b.id = p.bookId where p.userId = :user_id")
    List<PurchaseItem> findAllPurchaseOfUser(@Param("user_id") Long userId);
}

//@Query(value = "SELECT * FROM users_leads WHERE users_userid = ?1 AND leads_id NOT IN (SELECT won_leads_id FROM users_won_leads)", nativeQuery = true)
//@Query(value = "SELECT * FROM users_leads WHERE users_userid = :id AND leads_id NOT IN (SELECT won_leads_id FROM users_won_leads)", nativeQuery = true)
