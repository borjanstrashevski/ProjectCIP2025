package com.example.demo.dto;

import java.time.LocalDateTime;

// This class is for request to add auction history event.
public class AuctionHistoryRequest {
    private Long auctionId;
    private String eventType;
    private String details;
    private LocalDateTime eventTime;

    // Getters and setters for all fields
    public Long getAuctionId() { return auctionId; }
    public void setAuctionId(Long auctionId) { this.auctionId = auctionId; }
    public String getEventType() { return eventType; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
    public LocalDateTime getEventTime() { return eventTime; }
    public void setEventTime(LocalDateTime eventTime) { this.eventTime = eventTime; }
}
