package com.wyan.digital_account.repository;

import com.wyan.digital_account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByNumber(String number);

    Account findAccountByClientId(long clientId);
}
