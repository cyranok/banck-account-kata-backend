package com.kata.bank.account.domain.entity;

import com.kata.bank.account.domain.model.Account;
import com.kata.bank.account.domain.model.CreditRequest;
import com.kata.bank.account.domain.port.repository.AccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DepositEntityTest {


    @Autowired
    private DepositEntity depositEntity;


    @Test
    void makeDeposit() {

        //GIVEN
        CreditRequest request = CreditRequest.build("AAAA", BigDecimal.valueOf(45.15));

        //WHEN
        Account account = depositEntity.makeDeposit(request);

        //THEN
        Assertions.assertThat(account.getBalance()).isEqualTo( BigDecimal.valueOf(Double.valueOf(45.15)));
    }
}