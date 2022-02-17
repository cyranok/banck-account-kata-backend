package com.kata.bank.account.adapter.resource.dto;

import com.kata.bank.account.domain.model.WithDrawalResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DebitResponseDTO {

    private String acccountNumber;
    private BigDecimal accountBalance;
    private BigDecimal amountDebited;

    public static DebitResponseDTO build(WithDrawalResponse reponse){
        return new DebitResponseDTO(reponse.getAccountNumber(),reponse.getAccountBalance(), reponse.getDebitedAmount());
    }
}
