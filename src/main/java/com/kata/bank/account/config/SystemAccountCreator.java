package com.kata.bank.account.config;

import com.kata.bank.account.adapter.provider.gateway.AccountJpaRepository;
import com.kata.bank.account.adapter.provider.repository.entities.AccountEntity;
import com.kata.bank.account.domain.model.AccountType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class SystemAccountCreator implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SystemAccountCreator.class);

    private final AccountJpaRepository accountJpaRepository;

    public SystemAccountCreator(AccountJpaRepository accountJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Creating system account ....");
        accountJpaRepository.save(AccountEntity.build("0000",AccountType.SYSTEM,BigDecimal.ZERO));
        LOGGER.info("Creating user account ....");
        accountJpaRepository.save(AccountEntity.build("AAAA",AccountType.CURRENT,BigDecimal.ZERO));

    }
}
