package com.bootcamp.accountms.events;

import com.bootcamp.accountms.model.Account;

public record AccountEvent(String type, Long accountId, Long clientId, String status) {
  public static AccountEvent created(Account a) {
    return new AccountEvent("ACCOUNT_CREATED", a.getId(), a.getClientId(), a.getStatus());
  }
  public static AccountEvent updated(Account a) {
    return new AccountEvent("ACCOUNT_UPDATED", a.getId(), a.getClientId(), a.getStatus());
  }
}
