package com.cts.crm.model;

import jakarta.persistence.*;

@Entity
public class AnalyticsReportingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reportName;
    private String reportData;

    // Getters & Setters
}
