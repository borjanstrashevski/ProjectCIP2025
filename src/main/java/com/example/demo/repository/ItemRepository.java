package com.example.demo.repository;

import com.example.demo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// This interface is for Item repository. It help to talk to database for Item table.
public interface ItemRepository extends JpaRepository<Item, Long> {
    // Find items by auction id
    List<Item> findByAuctionId(Long auctionId);
}
