package com.kata.bank.account.domain.usecase;

import com.kata.bank.account.domain.entity.CheckNotSystemAccountEntity;
import com.kata.bank.account.domain.entity.DepositEntity;
import com.kata.bank.account.domain.model.Account;
import com.kata.bank.account.domain.model.CreditRequest;

public class MakeDeposit {

    private final DepositEntity depositEntity;
    private final CheckNotSystemAccountEntity checkNotSystemAccountEntity;

    public MakeDeposit(
            DepositEntity depositEntity,
            CheckNotSystemAccountEntity checkNotSystemAccountEntity) {
        this.depositEntity = depositEntity;
        this.checkNotSystemAccountEntity = checkNotSystemAccountEntity;
    }

    public Account credit(final CreditRequest request) {
        this.checkNotSystemAccountEntity.check(request.getAccountNumber());
        final Account account = depositEntity.makeDeposit(request);
        return account;
    }


}
