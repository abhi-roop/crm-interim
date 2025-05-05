package com.cts.crm.service;

import com.cts.crm.model.CustomerSupportTicket;
import java.util.List;

public interface CustomerSupportService {
    CustomerSupportTicket createTicket(CustomerSupportTicket ticket);
    CustomerSupportTicket getTicketById(Long id);
    List<CustomerSupportTicket> getAllTickets();
    CustomerSupportTicket updateTicket(Long id, CustomerSupportTicket ticket);
    void closeTicket(Long id);
}