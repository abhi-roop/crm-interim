package com.cts.crm.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.model.SalesAutomationModel;
import com.cts.crm.service.SalesAutomationService;

@RestController
@RequestMapping("/sales")
public class SalesAutomationController {

    @Autowired
    private SalesAutomationService salesAutomationService;

    // Save Sale Record (POST)
    @PostMapping("/save")
    public ResponseEntity<SalesAutomationModel> recordSale(@RequestBody SalesAutomationModel sale) {
        SalesAutomationModel savedSale = salesAutomationService.recordSale(sale);
        return new ResponseEntity<>(savedSale, HttpStatus.CREATED);
    }

    // Get All Sales (GET)
    @GetMapping("/get")
    public ResponseEntity<List<SalesAutomationModel>> getAllSales() {
        List<SalesAutomationModel> salesList = salesAutomationService.getAllSales();
        return salesList.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : ResponseEntity.ok(salesList);
    }

    // Get Sale By ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<SalesAutomationModel> getSaleById(@PathVariable Long id) {
        Optional<SalesAutomationModel> sale = salesAutomationService.getSaleById(id);
        return sale.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Get Sales By Product Name (GET)
    @GetMapping("/name/{productName}")
    public ResponseEntity<List<SalesAutomationModel>> getSalesByProductName(@PathVariable String productName) {
        List<SalesAutomationModel> salesList = salesAutomationService.getSalesByProductName(productName);
        return salesList.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : ResponseEntity.ok(salesList);
    }

    // Get Sales By Amount (GET)
    @GetMapping("/amount/{salesAmount}")
    public ResponseEntity<List<SalesAutomationModel>> getSalesByAmount(@PathVariable Double salesAmount) {
        List<SalesAutomationModel> salesList = salesAutomationService.getSalesByAmount(salesAmount);
        return salesList.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : ResponseEntity.ok(salesList);
    }
}
