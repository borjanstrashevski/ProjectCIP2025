package com.example.demo.repository;

import com.example.demo.model.AuctionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// This interface is for AuctionHistory repository. It help to talk to database for AuctionHistory table.
public interface AuctionHistoryRepository extends JpaRepository<AuctionHistory, Long> {
    // Find auction history by auction id
    List<AuctionHistory> findByAuctionId(Long auctionId);
}
