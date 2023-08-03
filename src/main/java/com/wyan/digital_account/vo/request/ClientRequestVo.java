package com.wyan.digital_account.vo.request;

import jakarta.validation.constraints.NotBlank;

public record ClientRequestVo(
        @NotBlank
        String name,
        @NotBlank
        String email,
        @NotBlank
        String cpf,
        @NotBlank
        String address,
        @NotBlank
        String cellphone
) {
}
