package com.kata.bank.account.domain.entity;

import com.kata.bank.account.adapter.provider.gateway.AccountJpaRepository;
import com.kata.bank.account.adapter.provider.repository.entities.AccountEntity;
import com.kata.bank.account.domain.model.AccountType;
import com.kata.bank.account.domain.model.CreditRequest;
import com.kata.bank.account.domain.model.WithDrawalRequest;
import com.kata.bank.account.domain.model.WithDrawalResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class WithDrawalEntityTest {

    @Autowired
    private WithDrawalEntity withDrawalEntity;

    @Autowired
    private DepositEntity depositEntity;

    @Autowired
    private AccountJpaRepository accountJpaRepository;

    @BeforeEach
    void bebebb(){
        accountJpaRepository.save(AccountEntity.build("BBBB", AccountType.CURRENT, BigDecimal.ZERO));
    }


    @Test
    void withdraw_when_insufficient_funds() {

        //GIVEN
        depositEntity.makeDeposit(CreditRequest.build("BBBB", BigDecimal.TEN));

        //WHEN
        WithDrawalResponse res = withDrawalEntity.withdraw(WithDrawalRequest.build("BBBB", BigDecimal.TEN));

        //THEN
       Assertions.assertThat(BigDecimal.ZERO.compareTo(res.getAccountBalance())).isEqualTo(0);
       Assertions.assertThat(res.getDebitedAmount()).isEqualTo(BigDecimal.TEN);
    }

}