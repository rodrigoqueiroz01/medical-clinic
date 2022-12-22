package com.dev.medicalclinic.domain.repository;

import com.dev.medicalclinic.domain.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    BankAccount findByTitularName(String titularName);

    BankAccount findByAccountNumber(String accountNumber);

    BankAccount findByPixKey(String pixKey);

}
