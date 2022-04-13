package com.anz.career.wholesale.enums;

import java.util.stream.Stream;

public enum TransactionTypeEnum {
  CREDIT("Credit"), DEBIT("Debit");

  private String transactionType;

  private TransactionTypeEnum(String transactionType) {
    this.transactionType = transactionType;
  }

  public String getTransactionType() {
    return transactionType;
  }

  public static TransactionTypeEnum of(String transactionType) {
    return Stream.of(TransactionTypeEnum.values())
        .filter(aT -> aT.getTransactionType().equals(transactionType))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

}
