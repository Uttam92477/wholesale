package com.anz.career.wholesale.transaction;

import java.util.ArrayList;
import java.util.Collection;

import com.anz.career.wholesale.projection.TransactionSummary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
  private final static Logger logger = LoggerFactory.getLogger(TransactionService.class);
  @Autowired
  private TransactionRepository transactionRepository;

  @Cacheable("transactions")
  public Collection<TransactionSummary> findTransactionsByAccountNumber(String accountNumber, Pageable pageable) {
    logger.info("Entered service function findTransactionsByAccountNumber()");
    Collection<TransactionSummary> transactions = new ArrayList<>();
    transactions = transactionRepository.findByAccountAccountNumber(accountNumber, pageable,
        TransactionSummary.class).getContent();
    logger.info("Exiting service function findTransactionsByAccountNumber()");
    return transactions;
  }

  /**
   * Obtains transactions based on both account number and transaction type.
   *
   * @param accountNumber
   * @param transactionType
   * @param pageable
   * @return
   */
  @Cacheable("transactions")
  public Collection<TransactionSummary> findTransactionsByAccountNumberAndTransactionType(String accountNumber,
      String transactionType, Pageable pageable) {
    logger.info("Entered service function findTransactionsByAccountNumberAndTransactionType()");
    Collection<TransactionSummary> transactions = new ArrayList<>();
    transactions = transactionRepository
        .findTransactionsByAccountAccountNumberAndTransactionType(accountNumber, transactionType,
            pageable,
            TransactionSummary.class)
        .getContent();
    logger.info("Exiting service function findTransactionsByAccountNumberAndTransactionType()");
    return transactions;
  }
}
