package com.cts.crm.repository;

import com.cts.crm.model.SalesAutomationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesAutomationRepository extends JpaRepository<SalesAutomationModel, Long> {
}