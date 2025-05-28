package com.example.demo.service;

import com.example.demo.dto.AuctionRequest;
import com.example.demo.model.Auction;
import com.example.demo.repository.AuctionRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

// This class is for business logic for Auction.
@Service
public class AuctionService {
    private final AuctionRepository auctionRepository;

    // Constructor for service. It get AuctionRepository.
    public AuctionService(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    // This method get all auctions, with optional filters.
    public List<Auction> filterAuctions(String status, LocalDateTime startTime) {
        if (status != null && startTime != null) {
            return auctionRepository.findByStatusAndStartTime(status, startTime);
        } else if (status != null) {
            return auctionRepository.findByStatus(status);
        } else if (startTime != null) {
            return auctionRepository.findByStartTime(startTime);
        } else {
            return auctionRepository.findAll();
        }
    }

    // This method get auction by id.
    public Auction getAuctionById(Long id) {
        return auctionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Auction not found with id: " + id));
    }

    // This method create new auction.
    public void createAuction(AuctionRequest auctionRequest) {
        Auction auction = new Auction();
        auction.setTitle(auctionRequest.getTitle());
        auction.setDescription(auctionRequest.getDescription());
        auction.setStartTime(auctionRequest.getStartTime());
        auction.setEndTime(auctionRequest.getEndTime());
        auction.setStatus("open");
        auction.setAutoExtendEnabled(auctionRequest.getAutoExtendEnabled());
        auctionRepository.save(auction);
    }

    // This method update status for auction (partial update).
    public void updateAuctionStatus(Long id, String status) {
        Auction auction = auctionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid auction ID: " + id));
        auction.setStatus(status);
        auctionRepository.save(auction);
    }

    // This method update the whole auction (full update).
    public Auction updateAuction(Long id, AuctionRequest auctionRequest) {
        Auction auction = auctionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Auction not found with id: " + id));
        auction.setTitle(auctionRequest.getTitle());
        auction.setDescription(auctionRequest.getDescription());
        auction.setStartTime(auctionRequest.getStartTime());
        auction.setEndTime(auctionRequest.getEndTime());
        auction.setAutoExtendEnabled(auctionRequest.getAutoExtendEnabled());
        // You can also update status if you want, or leave as is
        auctionRepository.save(auction);
        return auction;
    }

    // This method delete auction by id.
    public void deleteAuction(Long id) {
        if (!auctionRepository.existsById(id)) {
            throw new IllegalArgumentException("Auction not found with id: " + id);
        }
        auctionRepository.deleteById(id);
    }
}
