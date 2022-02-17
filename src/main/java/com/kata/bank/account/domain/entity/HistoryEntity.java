package com.kata.bank.account.domain.entity;

import com.kata.bank.account.domain.model.AccountHistory;
import com.kata.bank.account.domain.port.OperationRepository;

public class HistoryEntity {

    private final OperationRepository operationRepository;

    public HistoryEntity(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    public AccountHistory fetchAccountHistory(String accountNumber) {
        return new AccountHistory(
                accountNumber,
                operationRepository.getAccountOperations(accountNumber)
        );
    }
}
