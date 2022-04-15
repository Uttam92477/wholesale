package com.anz.career.wholesale.projection;

import java.util.Date;

public interface AccountSummary {
  String getAccountNumber();

  String getAccountName();

  String getAccountType();

  Date getBalanceDate();

  String getCurrency();

  Double getOpeningAvailableBalance();

  String getUserId();
}
