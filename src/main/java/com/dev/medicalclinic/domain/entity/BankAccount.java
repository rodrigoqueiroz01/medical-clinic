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
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    private String titularName;

    private Integer paydayOne;

    private Integer paydayTwo;

    private String bankingInstitution;

    private String agencyNumber;

    private String accountNumber;

    private String pixKey;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

}
