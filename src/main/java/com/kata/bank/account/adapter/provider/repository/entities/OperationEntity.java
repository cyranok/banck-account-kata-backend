package com.kata.bank.account.adapter.provider.repository.entities;

import com.kata.bank.account.domain.model.Operation;
import com.kata.bank.account.domain.model.OperationType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class OperationEntity implements Comparable<OperationEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private  OperationType type;

    @Column
    private  String accountNumber;

    @Column
    private  BigDecimal amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

   public static OperationEntity build(final Operation operation){
        OperationEntity operationEntity = new OperationEntity();
        operationEntity.setType(operation.getType());
        operationEntity.setAccountNumber(operation.getAccountNumber());
        operationEntity.setAmount(operation.getAmount());
        return operationEntity;
    }

    public static Operation build(final OperationEntity operationEntity){
        return new Operation(
                operationEntity.getType(),
                operationEntity.getAccountNumber(),
                operationEntity.getAmount()
        );
    }

    @Override
    public int compareTo(OperationEntity operationEntity) {
        return this.id.compareTo(operationEntity.id);
    }
}
