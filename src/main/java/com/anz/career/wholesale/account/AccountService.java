package com.anz.career.wholesale.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
  @Autowired
  private AccountRepository accountRepository;

  public List<Account> findAccountsByUserId(String userId) {
    return accountRepository.findByUserId(userId);
  }
}
