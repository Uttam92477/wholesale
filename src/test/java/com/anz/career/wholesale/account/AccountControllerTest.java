package com.anz.career.wholesale.account;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.anz.career.wholesale.projection.AccountSummary;

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
public class AccountControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private AccountService accountService;

  @Test
  void shouldReturnAccounts() throws Exception {
    AccountSummary account1 = new AccountSummary() {
      @Override
      public String getAccountNumber() {
        return "mockAcc1";
      }

      @Override
      public String getAccountName() {
        return "mockAccountName1";
      }

      @Override
      public String getAccountType() {
        return "Current";
      }

      @Override
      public Date getBalanceDate() {
        return Date.from(Instant.parse("2022-04-15T00:00:00.00Z"));
      }

      @Override
      public String getCurrency() {
        return "SGD";
      }

      @Override
      public Double getOpeningAvailableBalance() {
        return 120.23;
      }

      @Override
      public String getUserId() {
        return "1";
      }

    };
    Collection<AccountSummary> accounts = new ArrayList<>();
    accounts.add(account1);
    when(accountService.findAccountsByUserId("1", PageRequest.of(0, 20))).thenReturn(accounts);
    mockMvc.perform(get("/users/1/accounts").contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(
            "[{\"accountNumber\":\"mockAcc1\",\"accountName\":\"mockAccountName1\",\"accountType\":\"Current\",\"balanceDate\":\"2022-04-15T00:00:00.000+00:00\",\"currency\":\"SGD\",\"openingAvailableBalance\":120.23,\"userId\":\"1\"}]",
            false));
  }

}
