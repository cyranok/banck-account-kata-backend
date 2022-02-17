package com.kata.bank.account.domain.entity;

import com.kata.bank.account.adapter.provider.gateway.AccountJpaRepository;
import com.kata.bank.account.adapter.provider.repository.entities.AccountEntity;
import com.kata.bank.account.domain.exception.WithDrawalChecksException;
import com.kata.bank.account.domain.model.AccountType;
import com.kata.bank.account.domain.model.WithDrawalRequest;
import com.kata.bank.account.domain.model.WithDrawalResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PreWithDrawalCheckerTest {

    @Autowired
    private PreWithDrawalChecker preWithDrawalChecker;

    @Autowired
    private AccountJpaRepository accountJpaRepository;

    @BeforeEach
    void bebebb(){
        accountJpaRepository.save(AccountEntity.build("CCCC", AccountType.CURRENT, BigDecimal.ZERO));
    }


    @Test
    void check_insufficient_funds_throws_exception() {
        Assertions.assertThatThrownBy(()->preWithDrawalChecker.check(WithDrawalRequest.build("CCCC", BigDecimal.TEN))).isInstanceOf(WithDrawalChecksException.class).hasMessage("insufficient account balance");
    }
}