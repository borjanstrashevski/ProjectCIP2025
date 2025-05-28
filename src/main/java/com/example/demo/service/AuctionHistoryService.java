package com.example.demo.service;

import com.example.demo.dto.AuctionHistoryRequest;
import com.example.demo.model.AuctionHistory;
import com.example.demo.repository.AuctionHistoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

// This class is for business logic for AuctionHistory.
@Service
public class AuctionHistoryService {
    private final AuctionHistoryRepository auctionHistoryRepository;

    // Constructor for service. It get AuctionHistoryRepository.
    public AuctionHistoryService(AuctionHistoryRepository auctionHistoryRepository) {
        this.auctionHistoryRepository = auctionHistoryRepository;
    }

    // This method get all history for one auction.
    public List<AuctionHistory> getHistoryByAuctionId(Long auctionId) {
        return auctionHistoryRepository.findByAuctionId(auctionId);
    }

    // This method add new history event.
    public void addHistory(AuctionHistoryRequest request) {
        AuctionHistory history = new AuctionHistory();
        history.setAuctionId(request.getAuctionId());
        history.setEventType(request.getEventType());
        history.setDetails(request.getDetails());
        history.setEventTime(request.getEventTime());
        auctionHistoryRepository.save(history);
    }
}
