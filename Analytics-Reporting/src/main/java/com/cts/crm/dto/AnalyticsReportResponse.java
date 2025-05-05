// AnalyticsReportResponse.java
package com.cts.crm.dto;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Data
public class AnalyticsReportResponse {
    private String reportName;
    private LocalDateTime generationTimestamp;
    private Map<String, String> reportMetadata;
    private List<Map<String, Object>> data;
    private String outputFormat;
    private String fileUrl;
    private String errorMessage;
}