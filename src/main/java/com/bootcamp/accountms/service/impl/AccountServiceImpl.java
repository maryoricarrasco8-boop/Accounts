package com.bootcamp.accountms.service.impl;

import com.bootcamp.accountms.events.AccountEvent;
import com.bootcamp.accountms.events.AccountProducer;
import com.bootcamp.accountms.model.Account;
import com.bootcamp.accountms.repository.AccountRepository;
import com.bootcamp.accountms.service.AccountService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
  private final AccountRepository repo;
  private final AccountProducer producer;

  public AccountServiceImpl(AccountRepository repo, AccountProducer producer) {
    this.repo = repo;
    this.producer = producer;
  }

  @Override @Transactional
  public Account create(Account a) {
    a.setCreatedAt(OffsetDateTime.now());
    Account saved = repo.save(a);
    producer.publish(AccountEvent.created(saved));
    return saved;
  }

  @Override
  @Cacheable(cacheNames = "accountById", key = "#id")
  public Optional<Account> findById(Long id) {
    return repo.findById(id);
  }

  @Override
  public List<Account> findAll() {
    return repo.findAll();
  }

  @Override @Transactional
  @CachePut(cacheNames = "accountById", key = "#id")
  public Account update(Long id, Account a) {
    Account current = repo.findById(id).orElseThrow();
    current.setType(a.getType());
    current.setBalance(a.getBalance());
    current.setStatus(a.getStatus());
    Account saved = repo.save(current);
    producer.publish(AccountEvent.updated(saved));
    return saved;
  }

  @Override @Transactional
  @CacheEvict(cacheNames = "accountById", key = "#id")
  public void delete(Long id) {
    repo.deleteById(id);
  }
}
