package com.kata.bank.account.domain.usecase;

import com.kata.bank.account.domain.entity.CheckNotSystemAccountEntity;
import com.kata.bank.account.domain.entity.PreWithDrawalChecker;
import com.kata.bank.account.domain.entity.WithDrawalEntity;
import com.kata.bank.account.domain.model.WithDrawalRequest;
import com.kata.bank.account.domain.model.WithDrawalResponse;

public class MakeWithdrawal {
    private final PreWithDrawalChecker preWithDrawalChecker;
    private final CheckNotSystemAccountEntity checkNotSystemAccountEntity;
    private final WithDrawalEntity withDrawalEntity;

    public MakeWithdrawal(PreWithDrawalChecker preWithDrawalChecker, CheckNotSystemAccountEntity checkNotSystemAccountEntity, WithDrawalEntity withDrawalEntity) {
        this.preWithDrawalChecker = preWithDrawalChecker;
        this.checkNotSystemAccountEntity = checkNotSystemAccountEntity;
        this.withDrawalEntity = withDrawalEntity;
    }

    public WithDrawalResponse withDraw(WithDrawalRequest request){
        checkNotSystemAccountEntity.check(request.getAccountNumber());
        preWithDrawalChecker.check(request);
        return withDrawalEntity.withdraw(request);
    }

}
