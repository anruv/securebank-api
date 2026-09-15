package com.securebank.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/api/admin/status")
    public String getStatus() {
        return "Admin service is running";
    }
}
