package com.wyan.digital_account.service;

import com.wyan.digital_account.entity.Client;
import com.wyan.digital_account.mapper.AccountMapper;
import com.wyan.digital_account.mapper.ClientMapper;
import com.wyan.digital_account.repository.AccountRepository;
import com.wyan.digital_account.repository.ClientRepository;
import com.wyan.digital_account.vo.request.ClientRequestVo;
import com.wyan.digital_account.vo.response.AccountResponseVo;
import com.wyan.digital_account.vo.response.ClientResponseVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public void createClient(ClientRequestVo clientRequestVo) {
        Client client = clientMapper.toEntity(clientRequestVo);
        clientRepository.save(client);
    }

    public void updateClient(ClientRequestVo clientRequestVo, Long id) {
        final var client = getClient(id);
        client.setName(clientRequestVo.name());
        client.setCpf(clientRequestVo.cpf());
        client.setEmail(clientRequestVo.email());
        client.setAddress(clientRequestVo.address());
        client.setCellphone(clientRequestVo.cellphone());
        clientRepository.save(client);
    }

    public Client getClient(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    public void deleteClient(long id) {
        clientRepository.deleteById(id);
    }

    public List<ClientResponseVo> getAllClients() {
        List<ClientResponseVo> clientResponseVoList = new ArrayList<>();
        clientRepository.findAll().forEach(client -> clientResponseVoList.add(clientMapper.fromEntity(client)));
        return clientResponseVoList;
    }
}
