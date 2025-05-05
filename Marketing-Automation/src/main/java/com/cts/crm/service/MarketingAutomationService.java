package com.cts.crm.service;

import com.cts.crm.model.MarketingAutomationModel;
import java.util.List;

public interface MarketingAutomationService {
    MarketingAutomationModel createCampaign(MarketingAutomationModel campaign);
    MarketingAutomationModel getCampaignById(Long id);
    List<MarketingAutomationModel> getAllCampaigns();
    MarketingAutomationModel updateCampaign(Long id, MarketingAutomationModel campaign);
    void deleteCampaign(Long id); // Or perhaps deactivateCampaign
}