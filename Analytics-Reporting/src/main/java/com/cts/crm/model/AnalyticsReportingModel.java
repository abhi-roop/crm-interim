package com.cts.crm.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class AnalyticsReportingModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportId;
    private String reportName;
    @Column(columnDefinition = "TEXT")
    private String reportData;
    private LocalDateTime generationTimestamp;

    public AnalyticsReportingModel(Long reportId, String reportName, String reportData) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.reportData = reportData;
    }

    public AnalyticsReportingModel(Long reportId, String reportName, String reportData, LocalDateTime generationTimestamp) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.reportData = reportData;
        this.generationTimestamp = generationTimestamp;
    }
}