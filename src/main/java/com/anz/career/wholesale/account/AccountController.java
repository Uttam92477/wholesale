package com.anz.career.wholesale.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
  @Autowired
  private AccountService accountService;

  @GetMapping("/users/{userId}/accounts")
  public List<Account> account(@PathVariable String userId) {
    List<Account> accounts = accountService.findAccountsByUserId(userId);
    accounts.forEach((account) -> {
      System.out.println(account.getAccountType());
    });
    return accounts;
  }
}
