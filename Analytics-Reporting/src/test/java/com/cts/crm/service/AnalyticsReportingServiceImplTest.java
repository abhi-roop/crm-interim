package com.cts.crm.service;

import com.cts.crm.exception.ResourceNotFoundException;
import com.cts.crm.model.AnalyticsReportingModel;
import com.cts.crm.repository.AnalyticsReportingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class AnalyticsReportingServiceImplTest {

    @Mock
    private AnalyticsReportingRepository analyticsReportingRepository;

    @InjectMocks
    private AnalyticsReportingServiceImpl analyticsReportingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllReports_shouldReturnAllReportsFromRepository() {
        // Arrange
        AnalyticsReportingModel report1 = new AnalyticsReportingModel(1L, "Sales Report", "{data: 'sales'}");
        AnalyticsReportingModel report2 = new AnalyticsReportingModel(2L, "Marketing Report", "{data: 'marketing'}");
        List<AnalyticsReportingModel> expectedReports = Arrays.asList(report1, report2);

        when(analyticsReportingRepository.findAll()).thenReturn(expectedReports);

        // Act
        List<AnalyticsReportingModel> actualReports = analyticsReportingService.getAllReports();

        // Assert
        assertEquals(expectedReports.size(), actualReports.size());
        assertEquals(expectedReports.get(0).getReportName(), actualReports.get(0).getReportName());
        assertEquals(expectedReports.get(1).getReportData(), actualReports.get(1).getReportData());
    }

    @Test
    void generateReport_shouldSaveReportToRepository() {
        // Arrange
        AnalyticsReportingModel reportToSave = new AnalyticsReportingModel(null, "New Report", "{data: 'new data'}");
        AnalyticsReportingModel savedReport = new AnalyticsReportingModel(3L, "New Report", "{data: 'new data'}");

        when(analyticsReportingRepository.save(reportToSave)).thenReturn(savedReport);

        // Act
        AnalyticsReportingModel actualSavedReport = analyticsReportingService.generateReport(reportToSave);

        // Assert
        assertEquals(savedReport.getReportId(), actualSavedReport.getReportId()); // Corrected line
        assertEquals(savedReport.getReportName(), actualSavedReport.getReportName());
        assertEquals(savedReport.getReportData(), actualSavedReport.getReportData());
    }

    @Test
    void getReportById_shouldReturnReport_whenReportExists() {
        // Arrange
        Long reportId = 1L;
        AnalyticsReportingModel expectedReport = new AnalyticsReportingModel(reportId, "Specific Report", "{data: 'specific data'}");

        when(analyticsReportingRepository.findById(reportId)).thenReturn(Optional.of(expectedReport));

        // Act
        AnalyticsReportingModel actualReport = analyticsReportingService.getReportById(reportId);

        // Assert
        assertNotNull(actualReport);
        assertEquals(expectedReport.getReportId(), actualReport.getReportId());   // Corrected line
        assertEquals(expectedReport.getReportName(), actualReport.getReportName());
        assertEquals(expectedReport.getReportData(), actualReport.getReportData());
    }

    @Test
    void getReportById_shouldThrowResourceNotFoundException_whenReportDoesNotExist() {
        // Arrange
        Long reportId = 99L;

        when(analyticsReportingRepository.findById(reportId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(
                ResourceNotFoundException.class,
                () -> analyticsReportingService.getReportById(reportId)
        );
    }
}