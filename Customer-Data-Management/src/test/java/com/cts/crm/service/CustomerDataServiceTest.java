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
        CustomerData customer = new CustomerData(1L, "John Doe", "john@example.com", "Purchase History", "VIP");
        when(customerDataRepository.save(customer)).thenReturn(customer);

        CustomerData savedCustomer = customerDataService.saveCustomer(customer);

        assertNotNull(savedCustomer);
        assertEquals("John Doe", savedCustomer.getName());
    }
}
