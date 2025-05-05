package com.cts.crm.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "support_tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSupportTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketId;

    @NotBlank(message = "Issue title is required")
    private String issueTitle;

    @NotBlank(message = "Issue description cannot be empty")
    private String issueDescription;

    @NotBlank(message = "Ticket status is required")
    private String ticketStatus; // OPEN, IN_PROGRESS, CLOSED

    @NotBlank(message = "Customer contact is required")
    private String customerContact;
}
