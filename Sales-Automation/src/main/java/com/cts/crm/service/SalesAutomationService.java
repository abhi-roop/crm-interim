package com.cts.crm.service;

import com.cts.crm.model.SalesAutomationModel;
import java.util.List;
import java.util.Optional;

public interface SalesAutomationService {
    
    // Save a sale record
    SalesAutomationModel recordSale(SalesAutomationModel sale);
    
    // Get all sales records
    List<SalesAutomationModel> getAllSales();

    // Get a sale record by ID
    Optional<SalesAutomationModel> getSaleById(Long id);

    // Get sales records by product name
    List<SalesAutomationModel> getSalesByProductName(String productName);

    // Get sales records by sales amount
    List<SalesAutomationModel> getSalesByAmount(Double salesAmount);
}
