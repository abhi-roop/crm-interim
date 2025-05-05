package com.cts.crm.service;

import com.cts.crm.model.AnalyticsReportingModel;
import java.util.List;

public interface AnalyticsReportingService {
    List<AnalyticsReportingModel> getAllReports();
    AnalyticsReportingModel generateReport(AnalyticsReportingModel report);
}
