package com.wyan.digital_account.mapper;

import com.wyan.digital_account.entity.Account;
import com.wyan.digital_account.entity.Transaction;
import com.wyan.digital_account.vo.request.TransactionRequestVo;
import com.wyan.digital_account.vo.response.TransactionResponseVo;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TransactionMapper {

    public Transaction toEntity(TransactionRequestVo transactionRequestVo, Account account) {
        return Transaction.builder()
                .account(account)
                .amount(transactionRequestVo.amount())
                .type(transactionRequestVo.type())
                .description(transactionRequestVo.description())
                .transactionDate(Instant.now())
                .build();
    }

    public TransactionResponseVo fromEntity(Transaction transaction) {
        return new TransactionResponseVo(
                transaction.getAmount(),
                transaction.getType(),
                transaction.getDescription(),
                transaction.getTransactionDate()
        );
    }

}
