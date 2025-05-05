package com.cts.crm.controller;

import com.cts.crm.dto.SalesOpportunityRequest;
import com.cts.crm.dto.SalesOpportunityResponse;
import com.cts.crm.model.SalesAutomationModel;
import com.cts.crm.service.SalesAutomationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sales/opportunities")
public class SalesAutomationController {

    @Autowired
    private SalesAutomationService salesAutomationService;

    @PostMapping
    public ResponseEntity<SalesOpportunityResponse> createOpportunity(@Valid @RequestBody SalesOpportunityRequest opportunityRequest) {
        SalesAutomationModel createdOpportunity = salesAutomationService.createOpportunity(convertToEntity(opportunityRequest));
        return ResponseEntity.ok(convertToResponse(createdOpportunity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesOpportunityResponse> getOpportunity(@PathVariable Long id) {
        SalesAutomationModel opportunity = salesAutomationService.getOpportunityById(id);
        return ResponseEntity.ok(convertToResponse(opportunity));
    }

    @GetMapping
    public ResponseEntity<List<SalesOpportunityResponse>> getAllOpportunities() {
        List<SalesAutomationModel> opportunities = salesAutomationService.getAllOpportunities();
        return ResponseEntity.ok(opportunities.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalesOpportunityResponse> updateOpportunity(@PathVariable Long id, @Valid @RequestBody SalesOpportunityRequest opportunityRequest) {
        SalesAutomationModel updatedOpportunity = salesAutomationService.updateOpportunity(id, convertToEntity(opportunityRequest));
        return ResponseEntity.ok(convertToResponse(updatedOpportunity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpportunity(@PathVariable Long id) {
        salesAutomationService.deleteOpportunity(id);
        return ResponseEntity.noContent().build();
    }

    private SalesAutomationModel convertToEntity(SalesOpportunityRequest request) {
        SalesAutomationModel opportunity = new SalesAutomationModel();
        opportunity.setOpportunityName(request.getOpportunityName());
        opportunity.setEstimatedValue(request.getEstimatedValue());
        opportunity.setClosingDate(request.getClosingDate());
        opportunity.setSalesStage(request.getSalesStage());
        opportunity.setAssignedSalesRep(request.getAssignedSalesRep());
        return opportunity;
    }

    private SalesOpportunityResponse convertToResponse(SalesAutomationModel opportunity) {
        SalesOpportunityResponse response = new SalesOpportunityResponse();
        response.setOpportunityId(opportunity.getOpportunityId());
        response.setOpportunityName(opportunity.getOpportunityName());
        response.setEstimatedValue(opportunity.getEstimatedValue());
        response.setClosingDate(opportunity.getClosingDate());
        response.setSalesStage(opportunity.getSalesStage());
        response.setAssignedSalesRep(opportunity.getAssignedSalesRep());
        return response;
    }
}