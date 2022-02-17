package com.kata.bank.account.config;

import com.kata.bank.account.domain.entity.*;
import com.kata.bank.account.domain.port.OperationRepository;
import com.kata.bank.account.domain.port.repository.AccountRepository;
import com.kata.bank.account.domain.usecase.CheckHistory;
import com.kata.bank.account.domain.usecase.MakeDeposit;
import com.kata.bank.account.domain.usecase.MakeWithdrawal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContext {

    @Bean
    public DepositEntity depositEntity(AccountRepository accountRepository){
        return new DepositEntity(accountRepository);
    }

    @Bean
    public CheckNotSystemAccountEntity checkNotSystemAccountEntity(AccountRepository accountRepository){
        return new CheckNotSystemAccountEntity(accountRepository);
    }


    @Bean
    public MakeDeposit makeDeposit(
            DepositEntity depositEntity,
            CheckNotSystemAccountEntity checkNotSystemAccountEntity

    ){
        return new MakeDeposit(depositEntity,checkNotSystemAccountEntity);
    }


    @Bean
    public PreWithDrawalChecker preWithDrawalChecker(AccountRepository accountRepository){
        return new PreWithDrawalChecker(accountRepository);
    }

    @Bean
    public WithDrawalEntity withDrawalEntity(AccountRepository accountRepository){
        return new WithDrawalEntity(accountRepository);
    }

    @Bean
    public MakeWithdrawal makeWithdrawal(PreWithDrawalChecker preWithDrawalChecker, CheckNotSystemAccountEntity checkNotSystemAccountEntity,WithDrawalEntity withDrawalEntity){
        return new MakeWithdrawal(preWithDrawalChecker, checkNotSystemAccountEntity , withDrawalEntity);
    }

    @Bean
    public HistoryEntity historyEntity(OperationRepository operationRepository){
        return new HistoryEntity(operationRepository);
    }

    @Bean
    public CheckHistory checkHistory(HistoryEntity historyEntity){
        return new CheckHistory(historyEntity);
    }

}
