package com.cts.crm.model;

import jakarta.persistence.*;

@Entity
public class MarketingAutomationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String campaignName;
    private String audienceSegment;
    private String status;

    // Getters & Setters
}
