package com.kata.bank.account.adapter.provider.repository.entities;


import com.kata.bank.account.domain.model.Account;
import com.kata.bank.account.domain.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column
    private  AccountType type;

    @Column
    private  String number;

    @Column(precision = 9, scale = 2)
    private  BigDecimal balance;



    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public static Account build(AccountEntity accountEntity){
        return new Account(accountEntity.getType(), accountEntity.getNumber(), accountEntity.getBalance());
    }

    public static AccountEntity build(final String accountNumber, final AccountType type, final BigDecimal balance){
        return new AccountEntity(null, type, accountNumber, balance);
    }
}
