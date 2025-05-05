package com.cts.crm.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.crm.model.SalesAutomationModel;
import com.cts.crm.repository.SalesAutomationRepository;

@Service
public class SalesAutomationServiceImpl implements SalesAutomationService {

    @Autowired
    private SalesAutomationRepository repository;

    // Save Sale Record (POST)
    @Override
    public SalesAutomationModel recordSale(SalesAutomationModel sale) {
        return repository.save(sale);
    }

    // Get All Sales
    @Override
    public List<SalesAutomationModel> getAllSales() {
        return repository.findAll();
    }

    // Get Sale By ID
    @Override
    public Optional<SalesAutomationModel> getSaleById(Long id) {
        return repository.findById(id);
    }

    // Get Sales By Product Name
    @Override
    public List<SalesAutomationModel> getSalesByProductName(String productName) {
        return repository.findByProductName(productName);
    }

    // Get Sales By Amount
    @Override
    public List<SalesAutomationModel> getSalesByAmount(Double salesAmount) {
        return repository.findBySalesAmount(salesAmount);
    }
}
