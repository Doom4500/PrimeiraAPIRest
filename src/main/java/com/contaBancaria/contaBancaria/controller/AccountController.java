package com.contaBancaria.contaBancaria.controller;

import com.contaBancaria.contaBancaria.dto.CreateAccountDTO;
import com.contaBancaria.contaBancaria.errors.InvalidCpfException;
import com.contaBancaria.contaBancaria.model.Account;
import com.contaBancaria.contaBancaria.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping
    @Transactional
    public ResponseEntity<Account> create(@RequestBody @Valid CreateAccountDTO createAccountDTO, UriComponentsBuilder uriBuilder) throws InvalidCpfException {
        try {
            Account newAccount = accountService.create(createAccountDTO);
            URI uri = uriBuilder.path("/{id}").buildAndExpand(newAccount.getId()).toUri();
            return ResponseEntity.created(uri).body(newAccount);

        }catch(InvalidCpfException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,exception.getMessage(),exception);

        }

    }

    @GetMapping
    public ResponseEntity<List<Account>> list(String name){
        List<Account> accountList = accountService.find(name);
        return ResponseEntity.ok(accountList);

    }
}
