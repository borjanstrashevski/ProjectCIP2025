package com.example.demo.dto;

// This class is for request to place new bid.
public class BidRequest {
    private Long itemId;
    private Long bidderId;
    private Double amount;

    // Getters and setters for all fields
    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }
    public Long getBidderId() { return bidderId; }
    public void setBidderId(Long bidderId) { this.bidderId = bidderId; }
    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }
}
