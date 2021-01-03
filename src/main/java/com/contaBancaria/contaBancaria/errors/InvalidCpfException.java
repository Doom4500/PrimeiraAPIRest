package com.contaBancaria.contaBancaria.errors;

public class InvalidCpfException extends Exception{
    public InvalidCpfException(){super("CPF ja cadastrado");}
}
