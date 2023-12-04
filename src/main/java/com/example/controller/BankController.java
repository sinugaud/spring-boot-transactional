package com.example.controller;

import com.example.service.BankService;
import com.example.exception.InsufficientBalanceException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankService bankService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(
            @RequestParam long fromAccountId,
            @RequestParam long toAccountId,
            @RequestParam double amount) {
        try {
            bankService.transferMoney(fromAccountId, toAccountId, amount);
            return ResponseEntity.ok("Money transferred successfully");
        } catch (EntityNotFoundException | InsufficientBalanceException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
