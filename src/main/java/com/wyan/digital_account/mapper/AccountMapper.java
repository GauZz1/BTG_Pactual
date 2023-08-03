package com.wyan.digital_account.mapper;

import com.wyan.digital_account.entity.Account;
import com.wyan.digital_account.entity.Client;
import com.wyan.digital_account.vo.request.AccountRequestVo;
import com.wyan.digital_account.vo.response.AccountResponseVo;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public Account toEntity(AccountRequestVo accountRequestVo, Client client) {
        return Account.builder()
                .number(accountRequestVo.number())
                .balance(accountRequestVo.balance())
                .client(client)
                .build();
    }

    public AccountResponseVo fromEntity(Account account) {
        return new AccountResponseVo(account.getBalance(), account.getNumber());
    }

}
