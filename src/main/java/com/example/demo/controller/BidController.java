package com.example.demo.controller;

import com.example.demo.dto.BidRequest;
import com.example.demo.model.Bid;
import com.example.demo.service.BidService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This controller is for Bid endpoints. It handle HTTP request for bids.
@RestController
@RequestMapping("/api/v1/bids")
public class BidController {
    private final BidService bidService;

    // Constructor for controller. It get BidService.
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    // This endpoint get all bids for one auction.
    @GetMapping("/auction/{auctionId}")
    public List<Bid> getBidsByAuction(@PathVariable Long auctionId) {
        return bidService.getBidsByAuction(auctionId);
    }

    // This endpoint add new bid.
    @PostMapping("/auction/{auctionId}")
    public void placeBid(@RequestBody BidRequest bidRequest, @PathVariable Long auctionId) {
        bidService.placeBid(bidRequest, auctionId);
    }

    // This endpoint withdraw bid by id.
    @PatchMapping("/{bidId}/withdraw")
    public void withdrawBid(@PathVariable Long bidId) {
        bidService.withdrawBid(bidId);
    }
}
