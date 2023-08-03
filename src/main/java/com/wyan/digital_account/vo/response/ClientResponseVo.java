package com.wyan.digital_account.vo.response;

public record ClientResponseVo(
        String name,
        String email,
        String cpf,
        String address,
        String cellphone
) {
}
