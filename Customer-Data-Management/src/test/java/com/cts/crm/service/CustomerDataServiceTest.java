package com.cts.crm.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cts.crm.model.CustomerData;
import com.cts.crm.repository.CustomerDataRepository;

class CustomerDataServiceTest {

    @Mock
    private CustomerDataRepository customerDataRepository;

    @InjectMocks
    private CustomerDataServiceImpl customerDataService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCustomer() {
        // Create a CustomerData object with the correct fields
        CustomerData customer = new CustomerData();
        customer.setCustomerId(1L);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("john@example.com");
        customer.setPhone("1234567890");
        customer.setAddress("456 Oak St");

        // Mock the repository's save method to return the customer object
        when(customerDataRepository.save(customer)).thenReturn(customer);

        // Call the service method
        CustomerData savedCustomer = customerDataService.saveCustomer(customer);

        // Assertions
        assertNotNull(savedCustomer);
        assertEquals("John", savedCustomer.getFirstName());
        assertEquals("john@example.com", savedCustomer.getEmail());
    }
}