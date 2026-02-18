package com.sunidhi.springboot4versioning.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/{version}/tickets")
public class TicketController {

    // Version 1
    @GetMapping(version = "1.0")
    public ResponseEntity<String> v1() {
        return ResponseEntity.ok("Tickets V1");
    }

    // Version 2
    @GetMapping(version = "2.0")
    public ResponseEntity<String> v2() {
        return ResponseEntity.ok("Tickets V2 with extra fields");
    }

    // Summary
    @GetMapping(path = "/summary", version = "1.0")
    public ResponseEntity<String> summary() {
        return ResponseEntity.ok("Works for 1.0, 2.0...");
    }
}