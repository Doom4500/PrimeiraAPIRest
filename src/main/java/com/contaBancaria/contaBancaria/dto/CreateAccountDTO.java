package com.contaBancaria.contaBancaria.dto;

import com.contaBancaria.contaBancaria.model.Account;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class CreateAccountDTO {
    @NotNull
    private String name;
    @Email(message = "Email Invalido") @NotNull
    private String email;
    @CPF(message = "Cpf Invalido") @NotNull
    private String cpf;
    @NotNull @Past
    private Date birthDate;

    public Account toAccount(){
        Account account = new Account();
        account.setCpf(this.cpf);
        account.setEmail(this.email);
        account.setBirthDate(this.birthDate);
        account.setName(this.name);
        return account;
    }
    public String getCpf() {
        return cpf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
