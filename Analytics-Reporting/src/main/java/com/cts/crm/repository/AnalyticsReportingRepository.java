package com.cts.crm.repository;

import com.cts.crm.model.AnalyticsReportingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyticsReportingRepository extends JpaRepository<AnalyticsReportingModel, Long> {
}