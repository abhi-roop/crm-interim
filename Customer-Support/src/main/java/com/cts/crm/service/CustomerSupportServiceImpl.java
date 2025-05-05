package com.cts.crm.service;

import com.cts.crm.exception.ResourceNotFoundException; // Changed import
import com.cts.crm.model.CustomerSupportTicket;
import com.cts.crm.repository.CustomerSupportRepository;
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
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ticket ID " + id + " not found")); // Changed exception
	}

	@Override
	public List<CustomerSupportTicket> getAllTickets() {
		return repository.findAll();
	}

	@Override
	public CustomerSupportTicket updateTicket(Long id, CustomerSupportTicket ticket) {
		return repository.findById(id).map(existingTicket -> {
			ticket.setTicketId(id); // Ensure ID is set for update
			return repository.save(ticket);
		}).orElseThrow(() -> new ResourceNotFoundException("Ticket ID " + id + " not found")); // Changed exception
	}

	@Override
	public void closeTicket(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Ticket ID " + id + " not found"); // Changed exception
		}
		repository.deleteById(id);
	}
}