package com.anz.career.wholesale.transaction;

import java.util.ArrayList;
import java.util.Collection;
import com.anz.career.wholesale.projection.TransactionSummary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
  private final static Logger logger = LoggerFactory.getLogger(TransactionController.class);

  @Autowired
  private TransactionService transactionService;

  @GetMapping("/accounts/{accountNumber}/transactions")
  public ResponseEntity<Collection<TransactionSummary>> transaction(
      @PathVariable String accountNumber,
      @RequestParam(required = false) String transactionType,
      Pageable pageable) {
    logger.info("Request received for /accounts/{accountNumber}/transactions");
    Collection<TransactionSummary> transactions = new ArrayList<>();
    try {
      if (transactionType != null) {
        transactions = transactionService.findTransactionsByAccountNumberAndTransactionType(accountNumber,
            transactionType, pageable);
      } else {
        transactions = transactionService.findTransactionsByAccountNumber(accountNumber, pageable);
        logger.info(
            "Transactions obtained for /accounts/{accountNumber}/transactions based on transactionType parameter");
      }
      logger.info("Sending SUCCESS response for /accounts/{accountNumber}/transactions");
      return ResponseEntity.ok().body(transactions);
    } catch (Exception e) {
      logger
          .error("Sending error response for /accounts/{accountNumber}/transactions. Error occurred" + e.getMessage());
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(transactions);
    }

  }

}
