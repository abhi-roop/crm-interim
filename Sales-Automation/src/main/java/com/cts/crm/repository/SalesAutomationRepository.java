package com.cts.crm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.crm.model.SalesAutomationModel;

public interface SalesAutomationRepository extends JpaRepository<SalesAutomationModel, Long> {

	List<SalesAutomationModel> findBySalesAmount(Double salesAmount);

	List<SalesAutomationModel> findByProductName(String productName);
}
