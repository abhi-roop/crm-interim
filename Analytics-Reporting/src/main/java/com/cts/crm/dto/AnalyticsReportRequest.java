// AnalyticsReportRequest.java
package com.cts.crm.dto;

import lombok.Data;
import java.time.LocalDate;
import java.util.Map;
import java.util.List;

@Data
public class AnalyticsReportRequest {
    private String reportName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Map<String, Object> filters;
    private List<String> groupBy;
    private String sortBy;
    private String sortOrder;
    private String outputFormat;
    private Long campaignId;
    private String salesRepId;
    private String customerSegment;
}