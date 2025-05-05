package com.cts.crm.service;

import com.cts.crm.model.SalesAutomationModel;
import java.util.List;

public interface SalesAutomationService {
    SalesAutomationModel createOpportunity(SalesAutomationModel opportunity);
    SalesAutomationModel getOpportunityById(Long id);
    List<SalesAutomationModel> getAllOpportunities();
    SalesAutomationModel updateOpportunity(Long id, SalesAutomationModel opportunity);
    void deleteOpportunity(Long id);
}