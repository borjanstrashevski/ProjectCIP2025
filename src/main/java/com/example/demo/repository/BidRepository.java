package com.example.demo.repository;

import com.example.demo.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// This interface is for Bid repository. It help to talk to database for Bid table.
public interface BidRepository extends JpaRepository<Bid, Long> {
    // Find bids by auction id
    List<Bid> findByAuctionId(Long auctionId);

    // Find bids by item id
    List<Bid> findByItemId(Long itemId);
}
