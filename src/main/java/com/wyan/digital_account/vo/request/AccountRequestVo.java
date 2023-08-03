package com.wyan.digital_account.vo.request;

import jakarta.validation.constraints.NotBlank;

public record AccountRequestVo(
        double balance,
        @NotBlank
        String number,
        long clientId
) {
}
