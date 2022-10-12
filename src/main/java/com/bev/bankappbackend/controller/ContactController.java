package com.bev.bankappbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/contact")
    private String getContactDetails() {
        return "here are the contact details";
    }
}
