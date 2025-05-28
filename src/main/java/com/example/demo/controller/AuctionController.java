package com.example.demo.controller;

import com.example.demo.dto.AuctionRequest;
import com.example.demo.dto.AuctionStatusUpdateRequest;
import com.example.demo.model.Auction;
import com.example.demo.service.AuctionService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

// This controller is for Auction endpoints. It handle HTTP requests for auctions.
@RestController
@RequestMapping("/api/v1/auctions")
public class AuctionController {
    private final AuctionService auctionService;

    // Constructor for controller. It get AuctionService.
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    // This endpoint get all auctions. You can filter by status or start time.
    @GetMapping
    public List<Auction> getAuctions(
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "startTime", required = false) LocalDateTime startTime
    ) {
        return auctionService.filterAuctions(status, startTime);
    }

    // This endpoint get auction by id.
    @GetMapping("/{id}")
    public Auction getAuctionById(@PathVariable Long id) {
        return auctionService.getAuctionById(id);
    }

    // This endpoint create new auction.
    @PostMapping
    public void createAuction(@RequestBody AuctionRequest auctionRequest) {
        auctionService.createAuction(auctionRequest);
    }

    // This endpoint update status for auction (PATCH, partial update).
    @PatchMapping("/{id}/status")
    public void updateAuctionStatus(
            @PathVariable("id") Long id,
            @RequestBody AuctionStatusUpdateRequest statusUpdateRequest
    ) {
        auctionService.updateAuctionStatus(id, statusUpdateRequest.getStatus());
    }

    // This endpoint update the whole auction (PUT, full update).
    @PutMapping("/{id}")
    public Auction updateAuction(
            @PathVariable Long id,
            @RequestBody AuctionRequest auctionRequest
    ) {
        // This method replace all fields for auction with given id.
        return auctionService.updateAuction(id, auctionRequest);
    }

    // This endpoint delete auction by id.
    @DeleteMapping("/{id}")
    public void deleteAuction(@PathVariable Long id) {
        auctionService.deleteAuction(id);
    }
}
