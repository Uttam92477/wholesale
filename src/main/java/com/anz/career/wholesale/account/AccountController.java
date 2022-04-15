package com.anz.career.wholesale.account;

import java.util.Collection;

import com.anz.career.wholesale.projection.AccountSummary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
  @Autowired
  private AccountService accountService;

  @GetMapping(value = "/users/{userId}/accounts", produces = "application/json")
  public Collection<AccountSummary> account(
      @PathVariable String userId,
      @RequestParam(defaultValue = "0") int pageNo,
      @RequestParam(defaultValue = "3") int pageSize) {
    Collection<AccountSummary> accounts = accountService.findAccountsByUserId(userId, pageNo, pageSize);
    return accounts;
  }
}
