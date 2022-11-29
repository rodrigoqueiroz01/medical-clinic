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
import java.util.UUID;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true, nullable = false, length = 150)
    private String name;

    @Column(unique = true, nullable = false, length = 11)
    private String rg;

    @Column(unique = true, nullable = false, length = 14)
    private String cpf;

    @Column(name = "birth_date", nullable = false, length = 10)
    private String birthDate;

    @Column(nullable = false)
    private Integer age;

    @Column(name = "name_father", length = 150)
    private String nameFather;

    @Column(name = "mother_name", length = 150)
    private String motherName;

    @Column(name = "personal_phone", nullable = false, length = 15)
    private String personalPhone;

    @Column(name = "corporate_phone", nullable = false, length = 15)
    private String corporatePhone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenreType genre;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SchoolingType schooling;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(nullable = false, length = 150)
    private String email;

    @Embedded
    private AddressModel address;

    @Embedded
    private CollaborativeDataModel collaborativeData;

    private LocalDate registrationDate;

}
