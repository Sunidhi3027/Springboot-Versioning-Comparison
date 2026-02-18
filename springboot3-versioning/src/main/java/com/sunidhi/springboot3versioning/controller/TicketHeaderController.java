package com.sunidhi.springboot3versioning.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class TicketHeaderController {
    @RestController
    @RequestMapping("/api/tickets")
    public static class ticketHeaderController {

        @GetMapping
        public ResponseEntity<String> getTickets(HttpServletRequest request,
                                                 HttpServletResponse response) {

            String version = request.getHeader("API-Version");

            if (version == null) {
                return ResponseEntity.badRequest()
                        .body("API-Version header required");
            }

            return switch (version) {
                case "1.0" -> ResponseEntity.ok("Header Version 1.0");
                case "2.0" -> ResponseEntity.ok("Header Version 2.0");
                default -> ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Unsupported Version");
            };
        }
    }
}
