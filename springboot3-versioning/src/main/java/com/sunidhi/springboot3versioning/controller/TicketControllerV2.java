package com.sunidhi.springboot3versioning.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class TicketControllerV2 {
    @RestController
    @RequestMapping("/api/v2/tickets")
    public static class ticketControllerV2 {

        @GetMapping
        public ResponseEntity<String> getTickets() {
            return ResponseEntity.ok("Tickets V2 with extra fields");
        }
    }
}
