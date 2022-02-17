package com.kata.bank.account.adapter.provider.gateway;


import com.kata.bank.account.adapter.provider.repository.entities.AccountEntity;
import com.kata.bank.account.domain.model.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountJpaRepository  extends JpaRepository<AccountEntity, Long> {
     AccountEntity findByType(AccountType type);
     AccountEntity findByNumber(String accountNumber);
}
