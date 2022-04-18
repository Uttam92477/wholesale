package com.anz.career.wholesale.transaction;

import java.util.Collection;

import com.anz.career.wholesale.projection.TransactionSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
  @Autowired
  private TransactionRepository transactionRepository;

  @Cacheable("transactions")
  public Collection<TransactionSummary> findTransactionsByAccountNumber(String accountNumber, Pageable pageable) {
    return transactionRepository.findByAccountAccountNumber(accountNumber, pageable,
        TransactionSummary.class).getContent();

  }

  @Cacheable("transactions")
  public Collection<TransactionSummary> findTransactionsByAccountNumberAndTransactionType(String accountNumber,
      String transactionType, Pageable pageable) {
    return transactionRepository
        .findTransactionsByAccountAccountNumberAndTransactionType(accountNumber, transactionType,
            pageable,
            TransactionSummary.class)
        .getContent();
  }
}
