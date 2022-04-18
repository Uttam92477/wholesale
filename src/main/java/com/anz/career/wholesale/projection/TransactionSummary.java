package com.anz.career.wholesale.projection;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

/**
 * Interface based projections are used so that only the attributes required are
 * returned and not all columns from the DB
 */
public interface TransactionSummary {
  String getTransactionId();

  // Spring expression language is used to retrieve attributes from nested
  // instances. Here we are obtaining accountNumber from the parent Account
  // instance
  @Value("#{target.account.getAccountNumber()}")
  String getAccountNumber();

  Date getValueDate();

  String getCurrency();

  Double getDebitAmount();

  Double getCreditAmount();

  String getTransactionType();

  String getTransactionNarrative();
}
