package com.bootcamp.accountms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AccountMsApplication {
  public static void main(String[] args) {
    SpringApplication.run(AccountMsApplication.class, args);
  }
}
