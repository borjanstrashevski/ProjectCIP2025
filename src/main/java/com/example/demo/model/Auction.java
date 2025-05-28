package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

// This class is for Auction entity. It is table in database.
@Entity
@Table(name = "auctions")
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private Boolean autoExtendEnabled;

    public Auction() {} // Empty constructor

    // Getters and setters for all fields
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Boolean getAutoExtendEnabled() { return autoExtendEnabled; }
    public void setAutoExtendEnabled(Boolean autoExtendEnabled) { this.autoExtendEnabled = autoExtendEnabled; }
}
