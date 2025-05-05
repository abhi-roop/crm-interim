package com.cts.crm.dto;

import lombok.Data;

@Data
public class CustomerDataResponse {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
}