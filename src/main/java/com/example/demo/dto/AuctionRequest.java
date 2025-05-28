package com.example.demo.dto;

import java.time.LocalDateTime;

// This class is for request to create new auction.
public class AuctionRequest {
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean autoExtendEnabled;

    // Getters and setters for all fields
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public Boolean getAutoExtendEnabled() { return autoExtendEnabled; }
    public void setAutoExtendEnabled(Boolean autoExtendEnabled) { this.autoExtendEnabled = autoExtendEnabled; }
}
