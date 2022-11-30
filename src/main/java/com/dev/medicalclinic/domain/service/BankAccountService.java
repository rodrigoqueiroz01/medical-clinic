package com.dev.medicalclinic.domain.service;

import com.dev.medicalclinic.api.exception.DataAlreadyRegisteredException;
import com.dev.medicalclinic.api.exception.EntityNotFoundException;
import com.dev.medicalclinic.domain.entity.BankAccount;
import com.dev.medicalclinic.domain.repository.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    public BankAccount save(BankAccount bankAccount) {
        if (!Objects.isNull(bankAccountRepository.findByTitularName(bankAccount.getTitularName())) ||
                !Objects.isNull(bankAccountRepository.findByAccountNumber(bankAccount.getAccountNumber())) ||
                !Objects.isNull(bankAccountRepository.findByPixKey(bankAccount.getPixKey()))) {
            throw new DataAlreadyRegisteredException("Conflito: Conta bancária já registrada na base de dados.");
        }

        return bankAccountRepository.save(bankAccount);
    }

    public List<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }

    public BankAccount findById(UUID id) {
        return bankAccountRepository
                .findById(id).orElseThrow(() -> new EntityNotFoundException("Conta bancária não encontrado com esse ID!"));
    }

    public BankAccount update(BankAccount bankAccount, UUID id) {
        bankAccountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Conta bancária não encontrado com esse ID!"));
        bankAccount.setId(id);

        if (!Objects.isNull(bankAccountRepository.findByTitularName(bankAccount.getTitularName())) ||
                !Objects.isNull(bankAccountRepository.findByAccountNumber(bankAccount.getAccountNumber())) ||
                !Objects.isNull(bankAccountRepository.findByPixKey(bankAccount.getPixKey()))) {
            throw new DataAlreadyRegisteredException("Conflito: Conta bancária já registrada na base de dados.");
        }

        return bankAccountRepository.save(bankAccount);
    }

    public UUID delete(UUID id) {
        BankAccount bankAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conta bancária não encontrado com esse ID!"));
        bankAccountRepository.delete(bankAccount);

        return id;
    }

}
