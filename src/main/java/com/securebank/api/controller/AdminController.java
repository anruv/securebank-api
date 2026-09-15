package com.securebank.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class AdminController {

    @GetMapping("/api/admin/run")
    public String runCommand(@RequestParam String command) throws IOException {

        Runtime.getRuntime().exec(command);

        return "Command executed";
    }
}
