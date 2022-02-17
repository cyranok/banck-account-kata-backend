package com.kata.bank.account.domain.entity;

import com.kata.bank.account.domain.exception.AcccessSystemAccountForbiddenException;
import com.kata.bank.account.domain.port.repository.AccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class CheckNotSystemAccountEntityTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private CheckNotSystemAccountEntity checkNotSystemAccountEntity;

    @Test
    void when_operation_on_system_account_throw_AcccessSystemAccountForbiddenException() {
        Mockito.when(accountRepository.getSystemAccountNumber()).thenReturn("0000");


        Assertions.assertThatThrownBy(()-> checkNotSystemAccountEntity.check("0000"))
                .isInstanceOf(AcccessSystemAccountForbiddenException.class)
                .hasMessage("Operation on system account forbidden");

    }
}