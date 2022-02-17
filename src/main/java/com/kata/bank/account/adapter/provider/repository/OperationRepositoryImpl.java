package com.kata.bank.account.adapter.provider.repository;

import com.kata.bank.account.adapter.provider.gateway.OperationJpaRepository;
import com.kata.bank.account.adapter.provider.repository.entities.OperationEntity;
import com.kata.bank.account.domain.model.Operation;
import com.kata.bank.account.domain.port.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperationRepositoryImpl implements OperationRepository {

    private final OperationJpaRepository operationJpaRepository;

    public OperationRepositoryImpl(OperationJpaRepository operationJpaRepository) {
        this.operationJpaRepository = operationJpaRepository;
    }

    @Override
    public List<Operation> getAccountOperations(String accountNumber) {
        return operationJpaRepository.findByAccountNumber(accountNumber).stream()
                .sorted(Comparator.reverseOrder())
                .map(OperationEntity::build)
                .collect(Collectors.toList());
    }
}
