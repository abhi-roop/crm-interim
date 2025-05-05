package com.cts.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cts.crm.model.MarketingAutomationModel;
import com.cts.crm.service.MarketingAutomationService;

@RestController
@RequestMapping("/marketing")
public class MarketingAutomationController {

    @Autowired
    private MarketingAutomationService marketingAutomationService;

    @PostMapping
    public ResponseEntity<MarketingAutomationModel> createCampaign(@RequestBody MarketingAutomationModel campaign) {
        return ResponseEntity.ok(marketingAutomationService.createCampaign(campaign));
    }

    @GetMapping
    public ResponseEntity<List<MarketingAutomationModel>> getAllCampaigns() {
        return ResponseEntity.ok(marketingAutomationService.getAllCampaigns());
    }
}
