package com.cts.crm.controller;

import com.cts.crm.model.CustomerData;
import com.cts.crm.service.CustomerDataService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerDataControllerTest {

    @Mock
    private CustomerDataService customerDataService;

    @InjectMocks
    private CustomerDataController customerDataController;

    public CustomerDataControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCustomer() {
        CustomerData customer = new CustomerData(1L, "Jane Doe", "jane@example.com", "Purchase History", "Premium");
        when(customerDataService.saveCustomer(customer)).thenReturn(customer);

        ResponseEntity<CustomerData> response = customerDataController.createCustomer(customer);

        assertEquals(200, response.getStatusCode().value());
        assertEquals("Jane Doe", response.getBody().getName());
    }
}
