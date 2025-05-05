package com.cts.crm.service;

import com.cts.crm.exception.ResourceNotFoundException;
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
        return customerDataRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer with ID " + id + " not found"));
    }

    @Override
    public List<CustomerData> getAllCustomers() {
        return customerDataRepository.findAll();
    }

    @Override
    public CustomerData updateCustomer(Long id, CustomerData customer) {
        return customerDataRepository.findById(id)
                .map(existingCustomer -> {
                    customer.setCustomerId(id);
                    return customerDataRepository.save(customer);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Customer with ID " + id + " not found"));
    }

    @Override
    public void deleteCustomer(Long id) {
        if (!customerDataRepository.existsById(id)) {
            throw new ResourceNotFoundException("Customer with ID " + id + " not found");
        }
        customerDataRepository.deleteById(id);
    }
}