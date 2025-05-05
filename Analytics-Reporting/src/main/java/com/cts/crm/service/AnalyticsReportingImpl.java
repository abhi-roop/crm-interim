package com.cts.crm.service;

import com.cts.crm.model.AnalyticsReportingModel;
import com.cts.crm.repository.AnalyticsReportingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyticsReportingImpl implements AnalyticsReportingService {

    @Autowired
    private AnalyticsReportingRepository repository;

    @Override
    public List<AnalyticsReportingModel> getAllReports() {
        return repository.findAll();
    }

    @Override
    public AnalyticsReportingModel generateReport(AnalyticsReportingModel report) {
        return repository.save(report);
    }
}
