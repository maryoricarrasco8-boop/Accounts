package com.bootcamp.accountms.service;

import com.bootcamp.accountms.events.AccountProducer;
import com.bootcamp.accountms.model.Account;
import com.bootcamp.accountms.repository.AccountRepository;
import com.bootcamp.accountms.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.OffsetDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccountServiceTest {
  @Test
  void createPublishesEvent() {
    AccountRepository repo = mock(AccountRepository.class);
    AccountProducer producer = mock(AccountProducer.class);
    AccountServiceImpl svc = new AccountServiceImpl(repo, producer);

    Account a = Account.builder().clientId(1L).type("SAVINGS").balance(10.0).status("ACTIVE").build();
    when(repo.save(Mockito.any(Account.class))).thenAnswer(inv -> {
      Account saved = inv.getArgument(0);
      saved.setId(100L);
      saved.setCreatedAt(OffsetDateTime.now());
      return saved;
    });

    Account saved = svc.create(a);
    assertNotNull(saved.getId());
    verify(producer, times(1)).publish(any());
  }

  @Test
  void updateModifiesFields() {
    AccountRepository repo = mock(AccountRepository.class);
    AccountProducer producer = mock(AccountProducer.class);
    AccountServiceImpl svc = new AccountServiceImpl(repo, producer);

    Account existing = Account.builder().id(5L).clientId(2L).type("SAVINGS").balance(100.0).status("ACTIVE").build();
    when(repo.findById(5L)).thenReturn(Optional.of(existing));
    when(repo.save(any(Account.class))).thenAnswer(inv -> inv.getArgument(0));

    Account payload = Account.builder().type("CURRENT").balance(500.0).status("INACTIVE").build();
    Account updated = svc.update(5L, payload);
    assertEquals("CURRENT", updated.getType());
    assertEquals(500.0, updated.getBalance());
    verify(producer, times(1)).publish(any());
  }
}
