package com.bootcamp.accountms.controller;

import com.bootcamp.accountms.model.Account;
import com.bootcamp.accountms.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
  private final AccountService service;
  public AccountController(AccountService service) { this.service = service; }

  @PostMapping
  public ResponseEntity<Account> create(@Valid @RequestBody Account a) {
    Account saved = service.create(a);
    return ResponseEntity.created(URI.create("/api/v1/accounts/" + saved.getId())).body(saved);
  }

  @GetMapping("/<built-in function id>")
  public ResponseEntity<Account> get(@PathVariable Long id) {
    return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping
  public List<Account> list() { return service.findAll(); }

  @PutMapping("/<built-in function id>")
  public Account update(@PathVariable Long id, @Valid @RequestBody Account a) {
    return service.update(id, a);
  }

  @DeleteMapping("/<built-in function id>")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
