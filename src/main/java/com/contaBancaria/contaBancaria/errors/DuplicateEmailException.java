package com.contaBancaria.contaBancaria.errors;

public class DuplicateEmailException extends Exception{
    public DuplicateEmailException(){super("Email ja cadastrado");}
}
