package com.example.demo.controller;

import com.example.demo.dto.AuctionHistoryRequest;
import com.example.demo.model.AuctionHistory;
import com.example.demo.service.AuctionHistoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This controller is for AuctionHistory endpoints. It handle HTTP request for auction history.
@RestController
@RequestMapping("/api/v1/auction-history")
public class AuctionHistoryController {
    private final AuctionHistoryService auctionHistoryService;

    // Constructor for controller. It get AuctionHistoryService.
    public AuctionHistoryController(AuctionHistoryService auctionHistoryService) {
        this.auctionHistoryService = auctionHistoryService;
    }

    // This endpoint get all history for one auction.
    @GetMapping("/auction/{auctionId}")
    public List<AuctionHistory> getHistoryByAuction(@PathVariable Long auctionId) {
        return auctionHistoryService.getHistoryByAuctionId(auctionId);
    }

    // This endpoint add new history event.
    @PostMapping
    public void addHistory(@RequestBody AuctionHistoryRequest request) {
        auctionHistoryService.addHistory(request);
    }
}
