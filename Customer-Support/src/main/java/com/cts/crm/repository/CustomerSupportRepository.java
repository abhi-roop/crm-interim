package com.cts.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.crm.model.CustomerSupportTicket;

public interface CustomerSupportRepository extends JpaRepository<CustomerSupportTicket, Long> {}
