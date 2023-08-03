package com.wyan.digital_account.entity;

import com.wyan.digital_account.enumeration.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

@Entity
@Table(name = "transactions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    @Column
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column
    private double amount;

    @Column(name = "transaction_date")
    @CreatedDate
    private Instant transactionDate = Instant.now();

    @Column
    private String description;
}
