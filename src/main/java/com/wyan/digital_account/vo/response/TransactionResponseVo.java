package com.wyan.digital_account.vo.response;

import com.wyan.digital_account.enumeration.TransactionType;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record TransactionResponseVo(
        long id,
        double amount,
        @NotNull
        TransactionType type,
        String description,
        Instant transactionDate
) {
}
