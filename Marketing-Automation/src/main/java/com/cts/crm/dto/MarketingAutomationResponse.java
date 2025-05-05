package com.cts.crm.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MarketingAutomationResponse {
    private Long campaignId; // Assuming you still want this as the ID name
    private String campaignName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String targetAudience;
    private String status;
}