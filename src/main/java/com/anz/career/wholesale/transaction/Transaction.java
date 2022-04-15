package com.anz.career.wholesale.transaction;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.anz.career.wholesale.account.Account;
import com.anz.career.wholesale.enums.TransactionTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction implements Serializable {
  private static final long serialVersionUID = 1L;
  @Id
  private String transactionId;
  @ManyToOne
  @JoinColumn(name = "ACCOUNT_NUMBER")
  private Account account;
  private Date valueDate;
  private String currency;
  private Double debitAmount;
  private Double creditAmount;
  @Basic
  private String transactionType;
  @Transient
  private TransactionTypeEnum transactionTypeEnum;
  private String transactionNarrative;

  @PostLoad
  void fillTransient() {
    if (transactionType != null) {
      this.transactionTypeEnum = TransactionTypeEnum.of(transactionType);
    }
  }

  @PrePersist
  void fillPersistent() {
    if (transactionType != null) {
      this.transactionType = transactionTypeEnum.getTransactionType();
    }
  }
}
