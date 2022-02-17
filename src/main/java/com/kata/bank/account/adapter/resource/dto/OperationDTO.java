package com.kata.bank.account.adapter.resource.dto;

import com.kata.bank.account.domain.model.Operation;
import com.kata.bank.account.domain.model.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationDTO {
    private  OperationType type;
    private  String accountNumber;
    private  BigDecimal amount;


    public static OperationDTO build(final Operation operation){
        return new OperationDTO(operation.getType(), operation.getAccountNumber(), operation.getAmount());
    }
}
