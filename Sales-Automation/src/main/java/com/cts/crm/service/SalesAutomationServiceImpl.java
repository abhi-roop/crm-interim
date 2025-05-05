package com.cts.crm.service;

import com.cts.crm.exception.ResourceNotFoundException;
import com.cts.crm.model.SalesAutomationModel;
import com.cts.crm.repository.SalesAutomationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesAutomationServiceImpl implements SalesAutomationService {

    @Autowired
    private SalesAutomationRepository repository;

    @Override
    public SalesAutomationModel createOpportunity(SalesAutomationModel opportunity) {
        return repository.save(opportunity);
    }

    @Override
    public SalesAutomationModel getOpportunityById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sales Opportunity ID " + id + " not found"));
    }

    @Override
    public List<SalesAutomationModel> getAllOpportunities() {
        return repository.findAll();
    }

    @Override
    public SalesAutomationModel updateOpportunity(Long id, SalesAutomationModel opportunity) {
        return repository.findById(id)
                .map(existingOpportunity -> {
                    opportunity.setOpportunityId(id);
                    return repository.save(opportunity);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Sales Opportunity ID " + id + " not found"));
    }

    @Override
    public void deleteOpportunity(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Sales Opportunity ID " + id + " not found");
        }
        repository.deleteById(id);
    }
}