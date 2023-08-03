package com.wyan.digital_account.service;

import com.wyan.digital_account.entity.Account;
import com.wyan.digital_account.entity.Transaction;
import com.wyan.digital_account.enumeration.TransactionType;
import com.wyan.digital_account.mapper.TransactionMapper;
import com.wyan.digital_account.repository.AccountRepository;
import com.wyan.digital_account.repository.TransactionRepository;
import com.wyan.digital_account.vo.request.AccountRequestVo;
import com.wyan.digital_account.vo.request.TransactionRequestVo;
import com.wyan.digital_account.vo.response.TransactionResponseVo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final TransactionMapper transactionMapper;

    @Transactional
    public void createTransaction(TransactionRequestVo transactionRequestVo) {
        var account = accountRepository.findById(transactionRequestVo.accountId()).orElseThrow(() -> new EntityNotFoundException("Account not found"));
        Transaction transaction = transactionMapper.toEntity(transactionRequestVo, account);
        transactionRepository.save(transaction);

        double newBalance = TransactionType.DEPOSIT.equals(transactionRequestVo.type()) ?
                account.getBalance() + transaction.getAmount() :
                account.getBalance() - transaction.getAmount();
        account.setBalance(newBalance);
        accountRepository.save(account);
    }

    public Transaction getTransaction(long id) {
        return transactionRepository.findById(id).orElseThrow();
    }

    public List<TransactionResponseVo> getAllTransactions() {
        List<TransactionResponseVo> transactionResponseVoList = new ArrayList<>();
        transactionRepository.findAll().forEach(transaction -> transactionResponseVoList.add(transactionMapper.fromEntity(transaction)));
        return transactionResponseVoList;
    }

}
