package com.kata.bank.account.domain.port;

import com.kata.bank.account.domain.model.Operation;

import java.util.List;

public interface OperationRepository {
    List<Operation> getAccountOperations(String accountNumber);
}
