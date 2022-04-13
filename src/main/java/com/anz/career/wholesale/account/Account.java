package com.anz.career.wholesale.account;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.anz.career.wholesale.anzuser.ANZUser;
import com.anz.career.wholesale.enums.AccountTypeEnum;
import com.anz.career.wholesale.enums.CurrencyEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  private String accountNumber;
  private String accountName;

  @Basic
  private String accountType;
  @Transient
  private AccountTypeEnum accountTypeEnum;
  private Date balanceDate;
  @Basic
  private String currency;
  @Transient
  private CurrencyEnum currencyEnum;
  private Double openingAvailableBalance;
  @ManyToOne
  private ANZUser user;

  @PostLoad
  void fillTransient() {
    if (accountType != null) {
      this.accountTypeEnum = AccountTypeEnum.of(accountType);
    }
    if (currency != null) {
      this.currencyEnum = CurrencyEnum.of(currency);
    }
  }

  @PrePersist
  void fillPersistent() {
    if (accountType != null) {
      this.accountType = accountTypeEnum.getAccountType();
    }
    if (currency != null) {
      this.currency = currencyEnum.getCurrency();
    }
  }
}
