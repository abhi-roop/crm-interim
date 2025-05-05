package com.cts.crm.controller;

import com.cts.crm.model.CustomerSupportTicket;
import com.cts.crm.service.CustomerSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/support")
public class CustomerSupportController {

    @Autowired
    private CustomerSupportService customerSupportService;

    @PostMapping
    public ResponseEntity<CustomerSupportTicket> createTicket(@RequestBody CustomerSupportTicket ticket) {
        return ResponseEntity.ok(customerSupportService.createTicket(ticket));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerSupportTicket> getTicket(@PathVariable Long id) {
        return ResponseEntity.ok(customerSupportService.getTicketById(id));
    }

    @GetMapping
    public ResponseEntity<List<CustomerSupportTicket>> getAllTickets() {
        return ResponseEntity.ok(customerSupportService.getAllTickets());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerSupportTicket> updateTicket(@PathVariable Long id, @RequestBody CustomerSupportTicket ticket) {
        return ResponseEntity.ok(customerSupportService.updateTicket(id, ticket));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> closeTicket(@PathVariable Long id) {
        customerSupportService.closeTicket(id);
        return ResponseEntity.noContent().build();
    }
}
