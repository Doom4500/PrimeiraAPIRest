package com.contaBancaria.contaBancaria.service;

import com.contaBancaria.contaBancaria.dto.CreateAccountDTO;
import com.contaBancaria.contaBancaria.errors.InvalidCpfException;
import com.contaBancaria.contaBancaria.model.Account;
import com.contaBancaria.contaBancaria.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> find(String name){
        List<Account> accounts;
        if(name == null){
            accounts = accountRepository.findAll();
        }else{
            accounts = accountRepository.findByNameContaining(name);
        }

        return accounts;
    }

    public Account create(CreateAccountDTO createAccountDTO) throws InvalidCpfException {
        Optional<Account> accountCpf = accountRepository.findByCpf(createAccountDTO.getCpf());

        if(accountCpf.isPresent()){
            throw new InvalidCpfException();
        }
        Account newAccount = createAccountDTO.toAccount();
        accountRepository.save(newAccount);
        return newAccount;
    }
}
