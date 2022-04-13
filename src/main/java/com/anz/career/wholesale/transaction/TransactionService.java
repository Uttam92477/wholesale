package com.anz.career.wholesale.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
  @Autowired
  private TransactionRepository transactionRepository;

  public List<Transaction> findTransactionsByAccountNumber(String accountNumber) {
    return transactionRepository.findByAccountAccountNumber(accountNumber);
  }
}
