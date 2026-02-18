package com.sunidhi.springboot4versioning.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class TicketController {
    @RestController
    @RequestMapping("/api/{version}/tickets")
    public static class ticketController {

        // Version 1 only
        @GetMapping(version = "1.0")
        public ResponseEntity<String> v1() {
            return ResponseEntity.ok("Tickets V1");
        }

        // Version 2 only
        @GetMapping(version = "2.0")
        public ResponseEntity<String> v2() {
            return ResponseEntity.ok("Tickets V2 with extra fields");
        }

        // Baseline support
        @GetMapping(path = "/summary", version = "1.0+")
        public ResponseEntity<String> summary() {
            return ResponseEntity.ok("Works for 1.0, 1.1, 2.0, 3.0...");
        }
    }
}
