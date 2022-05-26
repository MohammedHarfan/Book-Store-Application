package com.store.repository;

import com.store.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<Purchase, Long> {

    @Query(value = "select b.title ,p.price ,p.purchase_Time from Purchase p left join Book b on b.id = p.book_id where p.user_id = :user_id")
    List<Purchase> findAllPurchaseOfUser(@Param("user_id") Long userId);
}

//@Query(value = "SELECT * FROM users_leads WHERE users_userid = ?1 AND leads_id NOT IN (SELECT won_leads_id FROM users_won_leads)", nativeQuery = true)
//@Query(value = "SELECT * FROM users_leads WHERE users_userid = :id AND leads_id NOT IN (SELECT won_leads_id FROM users_won_leads)", nativeQuery = true)
