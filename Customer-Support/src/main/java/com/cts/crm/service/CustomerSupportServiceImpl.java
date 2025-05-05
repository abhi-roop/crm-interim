package com.cts.crm.service;

import com.cts.crm.model.CustomerSupportTicket;
import com.cts.crm.repository.CustomerSupportRepository;
import com.cts.crm.exception.TicketNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerSupportServiceImpl implements CustomerSupportService {

    @Autowired
    private CustomerSupportRepository repository;

    @Override
    public CustomerSupportTicket createTicket(CustomerSupportTicket ticket) {
        return repository.save(ticket);
    }

    @Override
    public CustomerSupportTicket getTicketById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException("Ticket ID " + id + " not found"));
    }

    @Override
    public List<CustomerSupportTicket> getAllTickets() {
        return repository.findAll();
    }

    @Override
    public CustomerSupportTicket updateTicket(Long id, CustomerSupportTicket ticket) {
        CustomerSupportTicket existing = getTicketById(id);
        existing.setIssueTitle(ticket.getIssueTitle());
        existing.setIssueDescription(ticket.getIssueDescription());
        existing.setTicketStatus(ticket.getTicketStatus());
        return repository.save(existing);
    }

    @Override
    public void closeTicket(Long id) {
        repository.deleteById(id);
    }
}
