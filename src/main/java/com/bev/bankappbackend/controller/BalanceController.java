package com.bev.bankappbackend.controller;

import com.bev.bankappbackend.model.AccountTransactions;
import com.bev.bankappbackend.repo.AccountTransactionsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BalanceController {

    private final AccountTransactionsRepo accountTransactionsRepo;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam int id) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepo.
                findByCustomerIdOrderByTransactionDtDesc(id);
        if (accountTransactions != null ) {
            return accountTransactions;
        }else {
            return null;
        }
    }

}
