package com.anz.career.wholesale.account;

import java.util.ArrayList;
import java.util.Collection;

import com.anz.career.wholesale.projection.AccountSummary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
  private final static Logger logger = LoggerFactory.getLogger(AccountService.class);
  @Autowired
  private AccountRepository accountRepository;

  @Cacheable("accounts")
  public Collection<AccountSummary> findAccountsByUserId(String userId, Pageable pageable) {
    logger.info("Entered service function findAccountsByUserId()");
    Collection<AccountSummary> accounts = new ArrayList<>();
    accounts = accountRepository.findByUserId(userId, pageable,
        AccountSummary.class).getContent();
    accounts.forEach(account -> logger.debug("Account - " + account.toString()));
    logger.info("Exiting service function findAccountsByUserId()");
    return accounts;
  }
}
