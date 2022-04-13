package com.anz.career.wholesale.enums;

import java.util.stream.Stream;

public enum CurrencyEnum {
  SGD("SGD"), AUD("AUD");

  private String currency;

  private CurrencyEnum(String currency) {
    this.currency = currency;
  }

  public String getCurrency() {
    return currency;
  }

  public static CurrencyEnum of(String currency) {
    return Stream.of(CurrencyEnum.values())
        .filter(cur -> cur.getCurrency().equals(currency))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }

}
