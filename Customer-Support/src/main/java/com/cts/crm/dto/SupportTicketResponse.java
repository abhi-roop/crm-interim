package com.cts.crm.dto;

import lombok.Data;

@Data
public class SupportTicketResponse {
    private Long ticketId;
    private String issueTitle;
    private String issueDescription;
    private String ticketStatus;
    private String customerContact;
}