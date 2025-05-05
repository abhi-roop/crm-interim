package com.cts.crm.service;

import com.cts.crm.model.AnalyticsReportingModel;
import com.cts.crm.repository.AnalyticsReportingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AnalyticsReportingServiceImpl implements AnalyticsReportingService {

    @Autowired
    private AnalyticsReportingRepository reportingRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<AnalyticsReportingModel> getAllReports() {
        return reportingRepository.findAll();
    }

    @Override
    public AnalyticsReportingModel generateReport(AnalyticsReportingModel reportModel) {
        reportModel.setGenerationTimestamp(LocalDateTime.now());
        return reportingRepository.save(reportModel);
    }

    @Override
    public AnalyticsReportingModel getReportById(Long id) {
        return reportingRepository.findById(id).orElse(null);
    }
}