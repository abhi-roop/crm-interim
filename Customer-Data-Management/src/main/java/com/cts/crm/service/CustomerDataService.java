package com.cts.crm.service;

import com.cts.crm.model.CustomerData;

import java.util.List;

public interface CustomerDataService {
	CustomerData saveCustomer(CustomerData customer);

	CustomerData getCustomerById(Long id);

	List<CustomerData> getAllCustomers();

	CustomerData updateCustomer(Long id, CustomerData customer);

	void deleteCustomer(Long id);
}
