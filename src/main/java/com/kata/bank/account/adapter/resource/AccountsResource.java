package com.kata.bank.account.adapter.resource;

import com.kata.bank.account.adapter.resource.dto.*;
import com.kata.bank.account.domain.model.CreditRequest;
import com.kata.bank.account.domain.model.WithDrawalRequest;
import com.kata.bank.account.domain.usecase.CheckHistory;
import com.kata.bank.account.domain.usecase.MakeDeposit;
import com.kata.bank.account.domain.usecase.MakeWithdrawal;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@CrossOrigin("*")
public class AccountsResource {

    private final MakeWithdrawal makeWithdrawal;
    private final MakeDeposit makeDeposit;
    private final CheckHistory checkHistory;

    public AccountsResource(MakeWithdrawal makeWithdrawal, MakeDeposit makeDeposit, CheckHistory checkHistory) {
        this.makeWithdrawal = makeWithdrawal;
        this.makeDeposit = makeDeposit;
        this.checkHistory = checkHistory;
    }


    @PostMapping(path = "/{accountNumber}/debit")
    public HttpEntity<DebitResponseDTO> debit(@PathVariable(required = true) String accountNumber, @RequestBody DebitRequestDTO dto){
        return ResponseEntity.ok(
                DebitResponseDTO.build(makeWithdrawal.withDraw(WithDrawalRequest.build(accountNumber, dto.getAmount())))
        );
    }

    @PostMapping(path = "/{accountNumber}/credit")
    public HttpEntity<CreditResponseDTO> credit(@PathVariable(required = true) String accountNumber, @RequestBody CreditRequestDTO dto){
        return ResponseEntity.ok(
                CreditResponseDTO.build(makeDeposit.credit(CreditRequest.build(accountNumber, dto.getAmount())))
        );
    }

    @GetMapping(path = "/{accountNumber}")
    public HttpEntity<HistoryResponseDTO> history(@PathVariable(required = true) String accountNumber){
        return ResponseEntity.ok(
                HistoryResponseDTO.build(checkHistory.getHistory(accountNumber))
        );
    }

}
