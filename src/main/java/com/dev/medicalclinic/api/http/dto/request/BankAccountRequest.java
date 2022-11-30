package com.dev.medicalclinic.api.http.dto.request;

import com.dev.medicalclinic.domain.entity.enums.AccountType;
import com.dev.medicalclinic.domain.entity.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class BankAccountRequest {

    @NotBlank(message = "Este campo é obrigatório.")
    private String titularName;

    @NotNull(message = "Este campo é obrigatório.")
    private Integer paydayOne;

    @NotNull(message = "Este campo é obrigatório.")
    private Integer paydayTwo;

    @Length(max = 100, message = "Respeite o limite máximo de 100 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String bankingInstitution;

    @Length(max = 4, message = "Respeite o limite máximo de 4 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String agencyNumber;

    @Length(max = 20, message = "Respeite o limite máximo de 20 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String accountNumber;

    @Length(max = 255, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String pixKey;

    @NotBlank(message = "Este campo é obrigatório.")
    private AccountType accountType;

    @NotBlank(message = "Este campo é obrigatório.")
    private TransactionType transactionType;

}
