package com.anz.career.wholesale.account;

import java.util.Collection;

import com.anz.career.wholesale.projection.AccountSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
  @Autowired
  private AccountRepository accountRepository;

  @Cacheable("accounts")
  public Collection<AccountSummary> findAccountsByUserId(String userId, int pageNo, int pageSize) {
    return accountRepository.findByUserId(userId, PageRequest.of(pageNo, pageSize), AccountSummary.class)
        .getContent();
  }
}
