package com.cts.crm.repository;

import com.cts.crm.model.CustomerData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDataRepository extends JpaRepository<CustomerData, Long> {
}
