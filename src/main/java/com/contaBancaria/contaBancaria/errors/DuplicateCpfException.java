package com.contaBancaria.contaBancaria.errors;

public class DuplicateCpfException extends Exception{
    public DuplicateCpfException(){super("CPF ja cadastrado");}
}
