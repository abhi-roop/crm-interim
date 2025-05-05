package com.cts.crm.service;

import com.cts.crm.exception.ResourceNotFoundException;
import com.cts.crm.model.MarketingAutomationModel;
import com.cts.crm.repository.MarketingAutomationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketingAutomationServiceImpl implements MarketingAutomationService {

    @Autowired
    private MarketingAutomationRepository repository;

    @Override
    public MarketingAutomationModel createCampaign(MarketingAutomationModel campaign) {
        return repository.save(campaign);
    }

    @Override
    public MarketingAutomationModel getCampaignById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Campaign ID " + id + " not found"));
    }

    @Override
    public List<MarketingAutomationModel> getAllCampaigns() {
        return repository.findAll();
    }

    @Override
    public MarketingAutomationModel updateCampaign(Long id, MarketingAutomationModel campaign) {
        return repository.findById(id)
                .map(existingCampaign -> {
                    campaign.setCampaignId(id);
                    return repository.save(campaign);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Campaign ID " + id + " not found"));
    }

    @Override
    public void deleteCampaign(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Campaign ID " + id + " not found");
        }
        repository.deleteById(id);
    }
}