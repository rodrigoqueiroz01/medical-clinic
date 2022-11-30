package com.dev.medicalclinic.domain.entity;

import com.dev.medicalclinic.domain.entity.enums.AccountType;
import com.dev.medicalclinic.domain.entity.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bank_account", schema = "public")
public class BankAccount implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true, name = "titular_name", nullable = false)
    private String titularName;

    @Column(name = "payday_one", nullable = false)
    private Integer paydayOne;

    @Column(name = "payday_two", nullable = false)
    private Integer paydayTwo;

    @Column(name = "banking_institution", nullable = false, length = 100)
    private String bankingInstitution;

    @Column(name = "agency_number", nullable = false, length = 4)
    private String agencyNumber;

    @Column(unique = true, name = "account_number", nullable = false, length = 20)
    private String accountNumber;

    @Column(unique = true, name = "pix_key",nullable = false)
    private String pixKey;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", nullable = false)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

}
