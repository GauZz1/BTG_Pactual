package com.wyan.digital_account.vo.request;

import com.wyan.digital_account.enumeration.TransactionType;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

public record TransactionRequestVo(
        double amount,
        @NotNull
        TransactionType type,
        long accountId,
        String description

) {
}
