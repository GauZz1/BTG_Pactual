package com.wyan.digital_account.controller;

import com.wyan.digital_account.entity.Client;
import com.wyan.digital_account.mapper.ClientMapper;
import com.wyan.digital_account.service.AccountService;
import com.wyan.digital_account.service.ClientService;
import com.wyan.digital_account.vo.request.ClientRequestVo;
import com.wyan.digital_account.vo.response.AccountResponseVo;
import com.wyan.digital_account.vo.response.ClientResponseVo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final AccountService accountService;

    @GetMapping
    public List<ClientResponseVo> getAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping
    public void createClient(@RequestBody @Valid ClientRequestVo client) {
        clientService.createClient(client);
    }

    @PutMapping("{id}")
    public void updateClient(@RequestBody @Valid ClientRequestVo clientRequestVo, @PathVariable long id) {
        clientService.updateClient(clientRequestVo, id);
    }

    @GetMapping("{id}")
    public ClientResponseVo getClient(@PathVariable long id) {
        return clientMapper.fromEntity(clientService.getClient(id));
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.deleteClient(id);
    }

    @GetMapping("/{id}/account")
    public AccountResponseVo getClientAccount(@PathVariable long id) {
        return accountService.getClientAccount(id);
    }

}
