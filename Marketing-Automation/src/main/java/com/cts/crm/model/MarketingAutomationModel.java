package com.cts.crm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarketingAutomationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campaignId; // Assuming you still want this as the ID name

    private String campaignName;

    private LocalDate startDate;

    private LocalDate endDate;

    private String targetAudience;

    private String status; // e.g., ACTIVE, INACTIVE, COMPLETED
}