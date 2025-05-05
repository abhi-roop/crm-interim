package com.cts.crm.controller;

import com.cts.crm.model.AnalyticsReportingModel;
import com.cts.crm.service.AnalyticsReportingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/analytics")
public class AnalyticsReportingController {

    @Autowired
    private AnalyticsReportingService analyticsReportingService;

    @GetMapping
    public ResponseEntity<List<AnalyticsReportingModel>> getAllReports() {
        return ResponseEntity.ok(analyticsReportingService.getAllReports());
    }

    @PostMapping
    public ResponseEntity<AnalyticsReportingModel> generateReport(@RequestBody AnalyticsReportingModel report) {
        return ResponseEntity.ok(analyticsReportingService.generateReport(report));
    }
}
