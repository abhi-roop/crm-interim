package com.cts.crm.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SalesOpportunityResponse {
    private Long opportunityId;
    private String opportunityName;
    private Double estimatedValue;
    private LocalDate closingDate;
    private String salesStage;
    private String assignedSalesRep;
}