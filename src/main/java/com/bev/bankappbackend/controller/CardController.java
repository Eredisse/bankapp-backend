package com.bev.bankappbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @GetMapping("/myCards")
    private String getCardDetails() {
        return "Here are the card details";
    }
}
