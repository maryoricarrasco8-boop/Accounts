package com.bootcamp.accountms.service;

import com.bootcamp.accountms.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {
  Account create(Account a);
  Optional<Account> findById(Long id);
  List<Account> findAll();
  Account update(Long id, Account a);
  void delete(Long id);
}
