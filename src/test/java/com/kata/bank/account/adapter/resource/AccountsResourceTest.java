package com.kata.bank.account.adapter.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.bank.account.adapter.provider.gateway.AccountJpaRepository;
import com.kata.bank.account.adapter.provider.repository.entities.AccountEntity;
import com.kata.bank.account.adapter.resource.dto.CreditRequestDTO;
import com.kata.bank.account.adapter.resource.dto.DebitRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

@SpringBootTest
@AutoConfigureMockMvc
class AccountsResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AccountJpaRepository accountJpaRepository;

    @Test
    void debit() throws Exception {
        AccountEntity account = accountJpaRepository.findByNumber("AAAA");
        account.setBalance(BigDecimal.TEN);
        accountJpaRepository.save(account);

        mockMvc.perform(MockMvcRequestBuilders.post("/accounts/{accountNumber}/debit", "AAAA").contentType(MediaType.APPLICATION_JSON).content( new ObjectMapper().writeValueAsString(new DebitRequestDTO(BigDecimal.TEN)))).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void credit() throws Exception {
        AccountEntity account = accountJpaRepository.findByNumber("AAAA");
        account.setBalance(BigDecimal.TEN);
        accountJpaRepository.save(account);

        mockMvc.perform(MockMvcRequestBuilders.post("/accounts/{accountNumber}/credit", "AAAA").contentType(MediaType.APPLICATION_JSON).content( new ObjectMapper().writeValueAsString(new CreditRequestDTO(BigDecimal.TEN)))).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void history() throws Exception {

        AccountEntity account = accountJpaRepository.findByNumber("AAAA");
        account.setBalance(BigDecimal.TEN);
        accountJpaRepository.save(account);

        mockMvc.perform(MockMvcRequestBuilders.get("/accounts/{accountNumber}", "AAAA").contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());
    }
}