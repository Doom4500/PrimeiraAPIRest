package com.contaBancaria.contaBancaria.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String cpf;
    @Column(nullable = false) @Temporal(TemporalType.DATE)
    private Date birthDate;

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getCpf() { return cpf;}

    public void setCpf(String cpf) {this.cpf = cpf;}

    public Date getBirthDate() {return birthDate;}

    public void setBirthDate(Date birthDate) {this.birthDate = birthDate;}

    public Long getId(){return id;}

    public String getName(){return name;}

    public void setName(String name){this.name=name;}
}
