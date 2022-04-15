package com.anz.career.wholesale.transaction;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  <T> Page<T> findByAccountAccountNumber(String accountNumber, Pageable pageable, Class<T> type);

  <T> Page<T> findTransactionsByAccountAccountNumberAndTransactionType(String accountNumber, String transactionType,
      Pageable pageable, Class<T> type);
}
