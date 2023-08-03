package com.wyan.digital_account.repository;

import com.wyan.digital_account.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    public Transaction findTransactionByAccountId(long account_id);
}
