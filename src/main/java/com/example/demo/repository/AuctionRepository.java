package com.example.demo.repository;

import com.example.demo.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

// This interface is for Auction repository. It help to talk to database for Auction table.
public interface AuctionRepository extends JpaRepository<Auction, Long> {
    // Find auctions by status
    List<Auction> findByStatus(String status);

    // Find auctions by start time
    List<Auction> findByStartTime(LocalDateTime startTime);

    // Find auctions by status and start time
    List<Auction> findByStatusAndStartTime(String status, LocalDateTime startTime);
}
