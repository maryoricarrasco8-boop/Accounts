package com.bootcamp.accountms.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "accounts")
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Account {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private Long clientId;
  @Column(nullable = false)
  private String type; // SAVINGS, CURRENT, etc.
  @Column(nullable = false)
  private Double balance;
  @Column(nullable = false)
  private String status; // ACTIVE, INACTIVE
  @Column(nullable = false)
  private OffsetDateTime createdAt;
}
