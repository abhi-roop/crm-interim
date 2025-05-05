package com.cts.crm.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SupportTicketRequest {

    @NotBlank(message = "Issue title is required")
    private String issueTitle;

    @NotBlank(message = "Issue description cannot be empty")
    private String issueDescription;

    @NotBlank(message = "Ticket status is required")
    private String ticketStatus; // OPEN, IN_PROGRESS, CLOSED

    @NotBlank(message = "Customer contact is required")
    private String customerContact;
}