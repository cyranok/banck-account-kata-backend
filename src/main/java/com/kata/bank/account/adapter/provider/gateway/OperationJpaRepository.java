package com.kata.bank.account.adapter.provider.gateway;

import com.kata.bank.account.adapter.provider.repository.entities.OperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationJpaRepository extends JpaRepository<OperationEntity, Long> {

    List<OperationEntity> findByAccountNumber(String accountNumber);
}
