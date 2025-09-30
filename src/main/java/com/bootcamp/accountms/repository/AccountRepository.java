package com.bootcamp.accountms.repository;

import com.bootcamp.accountms.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
