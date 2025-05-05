package com.cts.crm.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.crm.dto.CustomerDataRequest;
import com.cts.crm.dto.CustomerDataResponse;
import com.cts.crm.model.CustomerData;
import com.cts.crm.service.CustomerDataService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerDataController {

    @Autowired
    private CustomerDataService customerDataService;

    @PostMapping
    public ResponseEntity<CustomerDataResponse> createCustomer(@Valid @RequestBody CustomerDataRequest customerRequest) {
        CustomerData createdCustomer = customerDataService.saveCustomer(convertToEntity(customerRequest));
        return ResponseEntity.ok(convertToResponse(createdCustomer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDataResponse> getCustomer(@PathVariable Long id) {
        CustomerData customer = customerDataService.getCustomerById(id);
        if (customer == null) {
            // You should throw a ResourceNotFoundException here (assuming you have it)
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToResponse(customer));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDataResponse>> getAllCustomers() {
        List<CustomerData> customers = customerDataService.getAllCustomers();
        return ResponseEntity.ok(customers.stream()
                                       .map(this::convertToResponse)
                                       .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDataResponse> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDataRequest customerRequest) {
        CustomerData updatedCustomer = customerDataService.updateCustomer(id, convertToEntity(customerRequest));
        if (updatedCustomer == null) {
            // You should throw a ResourceNotFoundException here
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(convertToResponse(updatedCustomer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerDataService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

    private CustomerData convertToEntity(CustomerDataRequest request) {
        CustomerData customer = new CustomerData();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        return customer;
    }

    private CustomerDataResponse convertToResponse(CustomerData customer) {
        CustomerDataResponse response = new CustomerDataResponse();
        response.setCustomerId(customer.getCustomerId());
        response.setFirstName(customer.getFirstName());
        response.setLastName(customer.getLastName());
        response.setEmail(customer.getEmail());
        response.setPhone(customer.getPhone());
        response.setAddress(customer.getAddress());
        return response;
    }
}