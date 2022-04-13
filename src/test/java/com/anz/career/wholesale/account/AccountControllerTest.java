package com.anz.career.wholesale.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import com.anz.career.wholesale.anzuser.ANZUser;
import com.anz.career.wholesale.enums.AccountTypeEnum;
import com.anz.career.wholesale.enums.CurrencyEnum;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import antlr.collections.List;

@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private AccountService accountService;

  @Test
  void shouldReturnAccounts() throws Exception {
    Account account1 = new Account(
        "mockAcc1", "mockAccountName1", "Current", AccountTypeEnum.CURRENT,
        Date.from(Instant.parse("2022-04-15T00:00:00.00Z")), "SGD", CurrencyEnum.SGD,
        120.23, new ANZUser("1"));
    ArrayList<Account> accounts = new ArrayList<>();
    accounts.add(account1);
    when(accountService.findAccountsByUserId("1")).thenReturn(accounts);
    mockMvc.perform(get("/users/1/accounts").contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json(
            "[{\"accountNumber\":\"mockAcc1\",\"accountName\":\"mockAccountName1\",\"accountType\":\"Current\",\"accountTypeEnum\":\"CURRENT\",\"balanceDate\":\"2022-04-15T00:00:00.000+00:00\",\"currency\":\"SGD\",\"currencyEnum\":\"SGD\",\"openingAvailableBalance\":120.23,\"user\":{\"id\":\"1\"}}]",
            false));
  }

}
