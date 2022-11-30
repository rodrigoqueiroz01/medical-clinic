package com.dev.medicalclinic.api.http.mapper;

import com.dev.medicalclinic.api.http.dto.request.BankAccountRequest;
import com.dev.medicalclinic.api.http.dto.response.BankAccountResponse;
import com.dev.medicalclinic.domain.entity.BankAccount;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BankAccountMapper {

    public static BankAccount toModel(BankAccountRequest bankAccountRequest) {
        return BankAccount
                .builder()
                .titularName(bankAccountRequest.getTitularName())
                .paydayOne(bankAccountRequest.getPaydayOne())
                .paydayTwo(bankAccountRequest.getPaydayTwo())
                .bankingInstitution(bankAccountRequest.getBankingInstitution())
                .agencyNumber(bankAccountRequest.getAgencyNumber())
                .accountNumber(bankAccountRequest.getAccountNumber())
                .pixKey(bankAccountRequest.getPixKey())
                .accountType(bankAccountRequest.getAccountType())
                .transactionType(bankAccountRequest.getTransactionType())
                .build();
    }

    public static BankAccountResponse toResponse(BankAccount bankAccount) {
        return BankAccountResponse
                .builder()
                .id(bankAccount.getId())
                .titularName(bankAccount.getTitularName())
                .paydayOne(bankAccount.getPaydayOne())
                .paydayTwo(bankAccount.getPaydayTwo())
                .bankingInstitution(bankAccount.getBankingInstitution())
                .agencyNumber(bankAccount.getAgencyNumber())
                .accountNumber(bankAccount.getAccountNumber())
                .pixKey(bankAccount.getPixKey())
                .accountType(bankAccount.getAccountType())
                .transactionType(bankAccount.getTransactionType())
                .build();
    }

    public static List<BankAccountResponse> toResponseList(List<BankAccount> bankAccountList) {
        if (Objects.isNull(bankAccountList) || bankAccountList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return bankAccountList.stream().map(BankAccountMapper::toResponse).collect(Collectors.toList());
        }
    }

}
