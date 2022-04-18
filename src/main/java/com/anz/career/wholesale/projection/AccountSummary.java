package com.anz.career.wholesale.projection;

import java.util.Date;

/**
 * Interface based projections are used so that only the attributes required are
 * returned and not all columns from the DB
 */
public interface AccountSummary {
  String getAccountNumber();

  String getAccountName();

  String getAccountType();

  Date getBalanceDate();

  String getCurrency();

  Double getOpeningAvailableBalance();

  String getUserId();
}
