package com.anz.career.wholesale.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
  @Autowired
  private TransactionService transactionService;

  @GetMapping("/accounts/{accountNumber}/transactions")
  public List<Transaction> transaction(@PathVariable String accountNumber) {
    List<Transaction> transactions = transactionService.findTransactionsByAccountNumber(accountNumber);
    return transactions;
  }

}
