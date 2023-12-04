package com.example.service;

import com.example.exception.InsufficientBalanceException;
import com.example.model.Account;
import com.example.repository.AccountRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void transferMoney(long fromAccountId, long toAccountId, double amount) throws InsufficientBalanceException {
        Account fromAccount = accountRepository.findById(fromAccountId).orElseThrow(EntityNotFoundException::new);
        Account toAccount = accountRepository.findById(toAccountId).orElseThrow(EntityNotFoundException::new);

        if (fromAccount.getBalance() >= amount) {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);

            accountRepository.save(fromAccount);
            accountRepository.save(toAccount);
        } else {
            throw new InsufficientBalanceException("Insufficient balance in the account");
        }
    }
}
