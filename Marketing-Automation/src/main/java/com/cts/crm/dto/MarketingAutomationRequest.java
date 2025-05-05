package com.cts.crm.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MarketingAutomationRequest {

    @NotBlank(message = "Campaign name is required")
    private String campaignName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String targetAudience;

    private String status; // e.g., ACTIVE, INACTIVE, COMPLETED
}