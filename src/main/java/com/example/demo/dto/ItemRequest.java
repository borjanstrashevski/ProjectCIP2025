package com.example.demo.dto;

// This class is for request to create new item.
public class ItemRequest {
    private Long auctionId;
    private String name;
    private String description;
    private Double startingPrice;

    // Getters and setters for all fields
    public Long getAuctionId() { return auctionId; }
    public void setAuctionId(Long auctionId) { this.auctionId = auctionId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Double getStartingPrice() { return startingPrice; }
    public void setStartingPrice(Double startingPrice) { this.startingPrice = startingPrice; }
}
