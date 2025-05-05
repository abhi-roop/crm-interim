package com.cts.crm.controller;

import com.cts.crm.dto.MarketingAutomationRequest;
import com.cts.crm.dto.MarketingAutomationResponse;
import com.cts.crm.model.MarketingAutomationModel;
import com.cts.crm.service.MarketingAutomationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/marketing")
public class MarketingAutomationController {

    @Autowired
    private MarketingAutomationService marketingAutomationService;

    @PostMapping("/campaigns")
    public ResponseEntity<MarketingAutomationResponse> createCampaign(@Valid @RequestBody MarketingAutomationRequest campaignRequest) {
        MarketingAutomationModel createdCampaign = marketingAutomationService.createCampaign(convertToEntity(campaignRequest));
        return ResponseEntity.ok(convertToResponse(createdCampaign));
    }

    @GetMapping("/campaigns/{id}")
    public ResponseEntity<MarketingAutomationResponse> getCampaign(@PathVariable Long id) {
        MarketingAutomationModel campaign = marketingAutomationService.getCampaignById(id);
        return ResponseEntity.ok(convertToResponse(campaign));
    }

    @GetMapping("/campaigns")
    public ResponseEntity<List<MarketingAutomationResponse>> getAllCampaigns() {
        List<MarketingAutomationModel> campaigns = marketingAutomationService.getAllCampaigns();
        return ResponseEntity.ok(campaigns.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList()));
    }

    @PutMapping("/campaigns/{id}")
    public ResponseEntity<MarketingAutomationResponse> updateCampaign(@PathVariable Long id, @Valid @RequestBody MarketingAutomationRequest campaignRequest) {
        MarketingAutomationModel updatedCampaign = marketingAutomationService.updateCampaign(id, convertToEntity(campaignRequest));
        return ResponseEntity.ok(convertToResponse(updatedCampaign));
    }

    @DeleteMapping("/campaigns/{id}")
    public ResponseEntity<Void> deleteCampaign(@PathVariable Long id) {
        marketingAutomationService.deleteCampaign(id);
        return ResponseEntity.noContent().build();
    }

    private MarketingAutomationModel convertToEntity(MarketingAutomationRequest request) {
        MarketingAutomationModel campaign = new MarketingAutomationModel();
        campaign.setCampaignName(request.getCampaignName());
        campaign.setStartDate(request.getStartDate());
        campaign.setEndDate(request.getEndDate());
        campaign.setTargetAudience(request.getTargetAudience());
        campaign.setStatus(request.getStatus());
        return campaign;
    }

    private MarketingAutomationResponse convertToResponse(MarketingAutomationModel campaign) {
        MarketingAutomationResponse response = new MarketingAutomationResponse();
        response.setCampaignId(campaign.getCampaignId());
        response.setCampaignName(campaign.getCampaignName());
        response.setStartDate(campaign.getStartDate());
        response.setEndDate(campaign.getEndDate());
        response.setTargetAudience(campaign.getTargetAudience());
        response.setStatus(campaign.getStatus());
        return response;
    }
}