package com.anz.career.wholesale.transaction;

import java.util.Collection;
import com.anz.career.wholesale.projection.TransactionSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
  @Autowired
  private TransactionService transactionService;

  @GetMapping("/accounts/{accountNumber}/transactions")
  public Collection<TransactionSummary> transaction(
      @PathVariable String accountNumber,
      @RequestParam(required = false) String transactionType,
      @RequestParam(defaultValue = "0") int pageNo,
      @RequestParam(defaultValue = "3") int pageSize) {
    Collection<TransactionSummary> transactions;
    if (transactionType != null) {
      transactions = transactionService.findTransactionsByAccountNumberAndTransactionType(accountNumber,
          transactionType, pageNo,
          pageSize);
    } else {
      transactions = transactionService.findTransactionsByAccountNumber(accountNumber,
          pageNo,
          pageSize);
    }

    return transactions;
  }

}
