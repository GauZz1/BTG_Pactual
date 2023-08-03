package com.wyan.digital_account.service;

import com.wyan.digital_account.entity.Account;
import com.wyan.digital_account.exception.EntityNotFoundException;
import com.wyan.digital_account.mapper.AccountMapper;
import com.wyan.digital_account.repository.AccountRepository;
import com.wyan.digital_account.repository.ClientRepository;
import com.wyan.digital_account.vo.request.AccountRequestVo;
import com.wyan.digital_account.vo.response.AccountResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;
    private final AccountMapper accountMapper;

    public void createAccount(AccountRequestVo accountRequestVo) {
        var client = clientRepository.findById(accountRequestVo.clientId()).orElseThrow(() -> new EntityNotFoundException("Client not found"));
        Account account = accountMapper.toEntity(accountRequestVo, client);
        accountRepository.save(account);
    }

    public void updateAccount(AccountRequestVo accountRequestVo, long id) {
        final var account = getAccount(id);
        account.setBalance(accountRequestVo.balance());
        account.setNumber(accountRequestVo.number());
        accountRepository.save(account);
    }

    public Account getAccount(long id) {
        return accountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Account not found"));
    }

    public void deleteAccount(long id) {
        accountRepository.deleteById(id);
    }

    public List<AccountResponseVo> getAllAccounts() {
        List<AccountResponseVo> accountResponseVoList = new ArrayList<>();
        accountRepository.findAll().forEach(account -> accountResponseVoList.add(accountMapper.fromEntity(account)));
        return accountResponseVoList;
    }

    public AccountResponseVo getClientAccount(long id) {
        return accountMapper.fromEntity(accountRepository.findAccountByClientId(id));
    }
}
