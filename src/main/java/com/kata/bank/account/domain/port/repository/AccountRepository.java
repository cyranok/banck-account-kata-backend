package com.kata.bank.account.domain.port.repository;

import com.kata.bank.account.domain.model.Account;
import com.kata.bank.account.domain.model.Operation;

import java.util.List;

public interface AccountRepository {

    /**
     *
     * @return
     */
    String getSystemAccountNumber();

    /**
     *
     * @param operations
     * @param customerAccountNumber
     * @return
     */
    Account makeDeposit(List<Operation> operations, String customerAccountNumber);

    /**
     *
     * @param accountNumber
     * @return
     */
    Account getAccountByNumber(String accountNumber);

    /**
     *
     * @param asList
     * @param accountNumber
     * @return
     */
    Account processWithDrawal(List<Operation> asList, String accountNumber);
}
