package com.cts.crm.controller;

import java.util.List;

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

import com.cts.crm.model.CustomerData;
import com.cts.crm.service.CustomerDataService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerDataController {

	@Autowired
	private CustomerDataService customerDataService;

	// Create a new customer
	@PostMapping
	public ResponseEntity<CustomerData> createCustomer(@Valid @RequestBody CustomerData customer) {
		return ResponseEntity.ok(customerDataService.saveCustomer(customer));
	}

	// Get customer by ID
	@GetMapping("/{id}")
	public ResponseEntity<CustomerData> getCustomer(@PathVariable Long id) {
		return ResponseEntity.ok(customerDataService.getCustomerById(id));
	}

	// Get all customers
	@GetMapping
	public ResponseEntity<List<CustomerData>> getAllCustomers() {
		return ResponseEntity.ok(customerDataService.getAllCustomers());
	}

	// Update a customer
	@PutMapping("/{id}")
	public ResponseEntity<CustomerData> updateCustomer(@PathVariable Long id,
			@Valid @RequestBody CustomerData customer) {
		return ResponseEntity.ok(customerDataService.updateCustomer(id, customer));
	}

	// Delete a customer
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
		customerDataService.deleteCustomer(id);
		return ResponseEntity.noContent().build();
	}
}
