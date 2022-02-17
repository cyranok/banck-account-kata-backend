package com.kata.bank.account.adapter.provider.repository;

import com.kata.bank.account.adapter.provider.gateway.AccountJpaRepository;
import com.kata.bank.account.adapter.provider.gateway.OperationJpaRepository;
import com.kata.bank.account.adapter.provider.repository.entities.AccountEntity;
import com.kata.bank.account.adapter.provider.repository.entities.OperationEntity;
import com.kata.bank.account.domain.exception.DepositException;
import com.kata.bank.account.domain.exception.WithDrawException;
import com.kata.bank.account.domain.model.Account;
import com.kata.bank.account.domain.model.AccountType;
import com.kata.bank.account.domain.model.Operation;
import com.kata.bank.account.domain.port.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountJpaRepository accountJpaRepository;
    private final OperationJpaRepository operationJpaRepository;
    private static String SYSTEM_ACCOUNT_NUMBER;

    public AccountRepositoryImpl(AccountJpaRepository accountJpaRepository, OperationJpaRepository operationJpaRepository) {
        this.accountJpaRepository = accountJpaRepository;
        this.operationJpaRepository = operationJpaRepository;
    }

    @Override
    public String getSystemAccountNumber() {
        if(SYSTEM_ACCOUNT_NUMBER == null){
            SYSTEM_ACCOUNT_NUMBER = accountJpaRepository.findByType(AccountType.SYSTEM).getNumber();
        }
        return SYSTEM_ACCOUNT_NUMBER;
    }

    @Override
    @Transactional
    public Account makeDeposit(List<Operation> operations, String customerAccountNumber) {
        try {
            return operations.stream()
                    .map(operation -> {
                        AccountEntity account = accountJpaRepository.findByNumber(operation.getAccountNumber());
                        account.setBalance(account.getBalance().add(operation.getAmount()));
                        operationJpaRepository.save(OperationEntity.build(operation));
                        return accountJpaRepository.save(account);
                    })
                    .filter(account -> account.getNumber().equals(customerAccountNumber))
                    .map(AccountEntity::build)
                    .collect(Collectors.toList())
                    .get(0);
        }catch (Exception ex){
            throw new DepositException("an error occured while performing the desposit");
        }
    }

    @Override
    public Account getAccountByNumber(String accountNumber) {
        return AccountEntity.build(accountJpaRepository.findByNumber(accountNumber));
    }

    @Override
    public Account processWithDrawal(List<Operation> operations, String accountNumber) {
     try{
         return operations.stream()
                 .map(this::performOperation)
                 .filter(account -> account.getNumber().equals(accountNumber))
                 .map(AccountEntity::build)
                 .collect(Collectors.toList())
                 .get(0);
     }catch (Exception ex){
         throw new WithDrawException("exception occured during withdawal");
     }
    }

    private AccountEntity performOperation(Operation operation){
        AccountEntity account = accountJpaRepository.findByNumber(operation.getAccountNumber());
        account.setBalance(account.getBalance().add(operation.getAmount()));
        operationJpaRepository.save(OperationEntity.build(operation));
        return accountJpaRepository.save(account);
    }
}
