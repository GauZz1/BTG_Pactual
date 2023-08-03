package com.wyan.digital_account.controller;

import com.wyan.digital_account.mapper.AccountMapper;
import com.wyan.digital_account.service.AccountService;
import com.wyan.digital_account.service.TransactionService;
import com.wyan.digital_account.vo.request.AccountRequestVo;
import com.wyan.digital_account.vo.response.AccountResponseVo;
import com.wyan.digital_account.vo.response.TransactionResponseVo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final AccountMapper accountMapper;
    private final TransactionService transactionService;

    @GetMapping
    public List<AccountResponseVo> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping
    public void createAccount(@RequestBody @Valid AccountRequestVo account) {
        accountService.createAccount(account);
    }

    @PutMapping("{id}")
    public void updateAccount(@RequestBody @Valid AccountRequestVo account, @PathVariable long id) {
        accountService.updateAccount(account, id);
    }

    @GetMapping("{id}")
    public AccountResponseVo getAccount(@PathVariable long id) {
        return accountMapper.fromEntity(accountService.getAccount(id));
    }

    @DeleteMapping("{id}")
    public void deleteAccount(@PathVariable long id) {
        accountService.deleteAccount(id);
    }

    @GetMapping("/{id}/transactions")
    public List<TransactionResponseVo> getClientAccount(@PathVariable long id) {
        return transactionService.getAccountTransactions(id);
    }
}
