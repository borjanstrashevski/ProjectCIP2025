package com.example.demo.service;

import com.example.demo.dto.BidRequest;
import com.example.demo.model.Bid;
import com.example.demo.repository.BidRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

// This class is for business logic for Bid.
@Service
public class BidService {
    private final BidRepository bidRepository;

    // Constructor for service. It get BidRepository.
    public BidService(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    // This method get all bids for one auction.
    public List<Bid> getBidsByAuction(Long auctionId) {
        return bidRepository.findByAuctionId(auctionId);
    }

    // This method add new bid.
    public void placeBid(BidRequest bidRequest, Long auctionId) {
        Bid bid = new Bid();
        bid.setAuctionId(auctionId);
        bid.setItemId(bidRequest.getItemId());
        bid.setBidderId(bidRequest.getBidderId());
        bid.setAmount(bidRequest.getAmount());
        bid.setTimestamp(LocalDateTime.now());
        bid.setStatus("active");
        bidRepository.save(bid);
    }

    // This method withdraw bid by id.
    public void withdrawBid(Long bidId) {
        Bid bid = bidRepository.findById(bidId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid bid ID: " + bidId));
        bid.setStatus("withdrawn");
        bidRepository.save(bid);
    }
}
