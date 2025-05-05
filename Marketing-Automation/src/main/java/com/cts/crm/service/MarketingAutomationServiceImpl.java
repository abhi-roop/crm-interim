package com.cts.crm.service;

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
    public List<MarketingAutomationModel> getAllCampaigns() {
        return repository.findAll();
    }
}
