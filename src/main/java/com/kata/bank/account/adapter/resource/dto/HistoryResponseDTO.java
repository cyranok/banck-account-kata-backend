package com.kata.bank.account.adapter.resource.dto;

import com.kata.bank.account.domain.model.AccountHistory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryResponseDTO {

    private String accountNumber;
    private List<OperationDTO> operations;

    public static HistoryResponseDTO build(final AccountHistory history){
        return new HistoryResponseDTO(history.getAccountNumber(), history.getOperations().stream().map(OperationDTO::build).collect(Collectors.toList()));
    }
}
