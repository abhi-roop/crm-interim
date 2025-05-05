package com.cts.crm.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SalesOpportunityRequest {

    @NotBlank(message = "Opportunity name is required")
    private String opportunityName;

    @Positive(message = "Estimated value must be positive")
    private Double estimatedValue;

    @Future(message = "Closing date must be in the future")
    private LocalDate closingDate;

    private String salesStage; // e.g., PROSPECTING, QUALIFICATION, PROPOSAL, CLOSING, CLOSED_WON, CLOSED_LOST

    private String assignedSalesRep;
}