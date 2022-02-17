package com.kata.bank.account.domain.usecase;

import com.kata.bank.account.domain.entity.HistoryEntity;
import com.kata.bank.account.domain.model.AccountHistory;

public class CheckHistory {

    private final HistoryEntity historyEntity;

    public CheckHistory(HistoryEntity historyEntity) {
        this.historyEntity = historyEntity;
    }

    public AccountHistory getHistory(String accountNumber){
        return historyEntity.fetchAccountHistory(accountNumber);
    }

}
