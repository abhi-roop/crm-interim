package com.cts.crm.service;

import com.cts.crm.model.CustomerData;
import com.cts.crm.repository.CustomerDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDataServiceImpl implements CustomerDataService {

	@Autowired
	private CustomerDataRepository customerDataRepository;

	@Override
	public CustomerData saveCustomer(CustomerData customer) {
		return customerDataRepository.save(customer);
	}

	@Override
	public CustomerData getCustomerById(Long id) {
		return customerDataRepository.findById(id).orElse(null);
	}

	@Override
	public List<CustomerData> getAllCustomers() {
		return customerDataRepository.findAll();
	}

	@Override
	public CustomerData updateCustomer(Long id, CustomerData customer) {
		if (customerDataRepository.existsById(id)) {
			customer.setCustomerId(id);
			return customerDataRepository.save(customer);
		}
		return null;
	}

	@Override
	public void deleteCustomer(Long id) {
		customerDataRepository.deleteById(id);
	}
}
