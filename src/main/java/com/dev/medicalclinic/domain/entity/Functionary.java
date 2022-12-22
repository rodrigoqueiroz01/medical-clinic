package com.dev.medicalclinic.domain.entity;

import com.dev.medicalclinic.domain.entity.enums.GenreType;
import com.dev.medicalclinic.domain.entity.enums.MaritalStatus;
import com.dev.medicalclinic.domain.entity.enums.SchoolingType;
import com.dev.medicalclinic.domain.entity.model.AddressModel;
import com.dev.medicalclinic.domain.entity.model.CollaborativeDataModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author rodrigoqueiroz
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "functionary", schema = "public")
public class Functionary implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    private String name;

    private String rg;

    private String cpf;

    private String birthDate;

    private Integer age;

    private String nameFather;

    private String motherName;

    private String personalPhone;

    private String corporatePhone;

    @Enumerated(EnumType.STRING)
    private GenreType genre;

    @Enumerated(EnumType.STRING)
    private SchoolingType schooling;

    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    private String email;

    @Embedded
    private AddressModel address;

    @Embedded
    private CollaborativeDataModel collaborativeData;

    @OneToOne
    @JoinColumn(name = "bank_account_id", unique = true, nullable = false)
    private BankAccount bankAccount;

    private LocalDate registrationDate;

}
