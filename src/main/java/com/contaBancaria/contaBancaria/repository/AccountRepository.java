package com.contaBancaria.contaBancaria.repository;

import com.contaBancaria.contaBancaria.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findByNameContaining(String name);
    Optional<Account> findByCpf(String cpf);
}
