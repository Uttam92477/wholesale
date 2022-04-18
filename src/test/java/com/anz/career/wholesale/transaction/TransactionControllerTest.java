package com.anz.career.wholesale.transaction;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.anz.career.wholesale.projection.TransactionSummary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TransactionControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private TransactionService transactionService;

  @Test
  void shouldReturnTransactions() throws Exception {
    TransactionSummary transaction1 = new TransactionSummary() {

      @Override
      public String getTransactionId() {
        return "mockTransaction1";
      }

      @Override
      public String getAccountNumber() {
        return "mockAccNum1";
      }

      @Override
      public Date getValueDate() {
        return Date.from(Instant.parse("2022-04-15T00:00:00.00Z"));
      }

      @Override
      public String getCurrency() {
        return "SGD";
      }

      @Override
      public Double getDebitAmount() {
        return 120.23;
      }

      @Override
      public Double getCreditAmount() {
        return null;
      }

      @Override
      public String getTransactionType() {
        return "Debit";
      }

      @Override
      public String getTransactionNarrative() {
        return "mockNarrative";
      }

    };
    Collection<TransactionSummary> transactions = new ArrayList<>();
    transactions.add(transaction1);
    when(transactionService.findTransactionsByAccountNumber("1", PageRequest.of(0, 20))).thenReturn(transactions);
    mockMvc.perform(get("/accounts/1/transactions").contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(
            "[{\"transactionId\":\"mockTransaction1\",\"accountNumber\":\"mockAccNum1\",\"valueDate\":\"2022-04-15T00:00:00.000+00:00\",\"currency\":\"SGD\",\"debitAmount\":120.23,\"creditAmount\":null,\"transactionType\":\"Debit\",\"transactionNarrative\":\"mockNarrative\"}]",
            false));
  }

  @Test
  void shouldReturnNotFound() throws Exception {
    mockMvc.perform(get("/non_existing_url")).andDo(print()).andExpect(status().isNotFound());
  }
}
