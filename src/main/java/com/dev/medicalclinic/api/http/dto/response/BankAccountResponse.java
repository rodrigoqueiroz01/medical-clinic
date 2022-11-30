package com.dev.medicalclinic.api.http.dto.response;

import com.dev.medicalclinic.domain.entity.enums.AccountType;
import com.dev.medicalclinic.domain.entity.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountResponse {

    private UUID id;
    private String titularName;
    private Integer paydayOne;
    private Integer paydayTwo;
    private String bankingInstitution;
    private String agencyNumber;
    private String accountNumber;
    private String pixKey;
    private AccountType accountType;
    private TransactionType transactionType;

}
