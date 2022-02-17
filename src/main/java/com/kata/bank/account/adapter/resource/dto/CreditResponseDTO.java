package com.kata.bank.account.adapter.resource.dto;

import com.kata.bank.account.domain.model.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditResponseDTO {
    private String accountNumber;
    private BigDecimal balance;

    public static CreditResponseDTO build(Account account){
        return new CreditResponseDTO(account.getNumber(), account.getBalance());
    }
}
