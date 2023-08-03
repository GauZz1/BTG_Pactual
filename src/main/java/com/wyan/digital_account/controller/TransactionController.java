package com.wyan.digital_account.controller;

import com.wyan.digital_account.mapper.TransactionMapper;
import com.wyan.digital_account.service.TransactionService;
import com.wyan.digital_account.vo.request.TransactionRequestVo;
import com.wyan.digital_account.vo.response.TransactionResponseVo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @GetMapping
    public List<TransactionResponseVo> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public void createTransaction(@RequestBody @Valid TransactionRequestVo transaction) {
        transactionService.createTransaction(transaction);
    }

    @GetMapping("{id}")
    public TransactionResponseVo getTransaction(@PathVariable long id) {
        return transactionMapper.fromEntity(transactionService.getTransaction(id));
    }
}
