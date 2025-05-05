package com.cts.crm.service;

import com.cts.crm.model.MarketingAutomationModel;
import java.util.List;

public interface MarketingAutomationService {
    MarketingAutomationModel createCampaign(MarketingAutomationModel campaign);
    List<MarketingAutomationModel> getAllCampaigns();
}
