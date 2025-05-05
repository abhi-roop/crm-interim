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
public class SalesAutomationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long opportunityId;

    private String opportunityName;

    private Double estimatedValue;

    private LocalDate closingDate;

    private String salesStage;

    private String assignedSalesRep;
}