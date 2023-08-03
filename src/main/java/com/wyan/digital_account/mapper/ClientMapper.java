package com.wyan.digital_account.mapper;

import com.wyan.digital_account.entity.Client;
import com.wyan.digital_account.vo.request.ClientRequestVo;
import com.wyan.digital_account.vo.response.ClientResponseVo;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    public Client toEntity(ClientRequestVo clientRequestVo) {
        return Client.builder()
                .name(clientRequestVo.name())
                .cpf(clientRequestVo.cpf())
                .email(clientRequestVo.email())
                .address(clientRequestVo.address())
                .cellphone(clientRequestVo.cellphone())
                .build();
    }

    public ClientResponseVo fromEntity(Client client) {
        return new ClientResponseVo(
                client.getName(),
                client.getCpf(),
                client.getEmail(),
                client.getEmail(),
                client.getCellphone()
        );
    }

}
