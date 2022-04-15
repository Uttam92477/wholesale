package com.anz.career.wholesale.projection;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;

public interface TransactionSummary {
  String getTransactionId();

  @Value("#{target.account.getAccountNumber()}")
  String getAccountNumber();

  Date getValueDate();

  String getCurrency();

  Double getDebitAmount();

  Double getCreditAmount();

  String getTransactionType();

  String getTransactionNarrative();
}
