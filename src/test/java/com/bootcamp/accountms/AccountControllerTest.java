package com.bootcamp.accountms.controller;

import com.bootcamp.accountms.model.Account;
import com.bootcamp.accountms.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {
  @Autowired
  MockMvc mvc;

  @MockBean
  AccountService service;

  @Test
  void getNotFound() throws Exception {
    when(service.findById(999L)).thenReturn(Optional.empty());
    mvc.perform(get("/api/v1/accounts/999").accept(MediaType.APPLICATION_JSON))
       .andExpect(status().isNotFound());
  }
}
