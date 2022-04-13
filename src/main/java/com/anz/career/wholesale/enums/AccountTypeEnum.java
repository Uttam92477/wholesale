package com.anz.career.wholesale.enums;

import java.util.stream.Stream;

public enum AccountTypeEnum {
  CURRENT("Current"), SAVINGS("Savings");

  private String accountType;

  private AccountTypeEnum(String accountType) {
    this.accountType = accountType;
  }

  public String getAccountType() {
    return accountType;
  }

  public static AccountTypeEnum of(String accountType) {
    return Stream.of(AccountTypeEnum.values())
        .filter(aT -> aT.getAccountType().equals(accountType))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

}
