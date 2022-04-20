package com.anz.career.wholesale.account;

import java.util.ArrayList;
import java.util.Collection;

import com.anz.career.wholesale.projection.AccountSummary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
  private final static Logger logger = LoggerFactory.getLogger(AccountController.class);
  @Autowired
  private AccountService accountService;

  @GetMapping(value = "/users/{userId}/accounts", produces = "application/json")
  public ResponseEntity<Collection<AccountSummary>> getUserAccounts(
      @PathVariable String userId,
      Pageable pageable) {
    logger.info("Request received for /users/{userId}/accounts");
    Collection<AccountSummary> accounts = new ArrayList<>();
    try {
      accounts = accountService.findAccountsByUserId(userId, pageable);
      logger.info("Sending SUCCESS response for /users/{userId}/accounts");
      return ResponseEntity.ok().body(accounts);
    } catch (Exception e) {
      logger.error("Sending error response for /users/{userId}/accounts. Error occurred" + e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(accounts);
    }

  }
}
