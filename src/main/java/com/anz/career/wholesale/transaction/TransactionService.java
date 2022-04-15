package com.anz.career.wholesale.transaction;

import java.util.Collection;

import com.anz.career.wholesale.projection.TransactionSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
  @Autowired
  private TransactionRepository transactionRepository;

  @Cacheable("transactions")
  public Collection<TransactionSummary> findTransactionsByAccountNumber(String accountNumber, int pageNo,
      int pageSize) {
    return transactionRepository.findByAccountAccountNumber(accountNumber, PageRequest.of(pageNo, pageSize),
        TransactionSummary.class).getContent();

  }

  @Cacheable("transactions")
  public Collection<TransactionSummary> findTransactionsByAccountNumberAndTransactionType(String accountNumber,
      String transactionType, int pageNo,
      int pageSize) {
    return transactionRepository
        .findTransactionsByAccountAccountNumberAndTransactionType(accountNumber, transactionType,
            PageRequest.of(pageNo, pageSize),
            TransactionSummary.class)
        .getContent();
  }
}
