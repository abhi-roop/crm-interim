// AnalyticsReportingController.java
package com.cts.crm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.dto.AnalyticsReportRequest;
import com.cts.crm.dto.AnalyticsReportResponse;
import com.cts.crm.model.AnalyticsReportingModel;
import com.cts.crm.service.AnalyticsReportingService;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/analytics/reports")
public class AnalyticsReportingController {
    @Autowired
    private AnalyticsReportingService analyticsReportingService;
    @Autowired
    private ObjectMapper objectMapper;
    @PostMapping("/generate")
    public ResponseEntity<AnalyticsReportResponse> generateReport(@Valid @RequestBody AnalyticsReportRequest reportRequest) {
        AnalyticsReportingModel reportModel = convertRequestToModel(reportRequest);
        AnalyticsReportingModel generatedReportModel = analyticsReportingService.generateReport(reportModel);
        AnalyticsReportResponse reportResponse = convertModelToResponse(generatedReportModel);
        return new ResponseEntity<>(reportResponse, HttpStatus.OK);
    }
    private AnalyticsReportingModel convertRequestToModel(AnalyticsReportRequest request) {
        AnalyticsReportingModel model = new AnalyticsReportingModel();
        model.setReportName(request.getReportName());
        return model;
    }
    private AnalyticsReportResponse convertModelToResponse(AnalyticsReportingModel model) {
        AnalyticsReportResponse response = new AnalyticsReportResponse();
        response.setReportName(model.getReportName());
        response.setGenerationTimestamp(java.time.LocalDateTime.now());
        response.setData(List.of(Map.of("reportData", model.getReportData())));
        return response;
    }
}