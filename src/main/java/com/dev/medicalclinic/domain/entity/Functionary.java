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
import java.util.Date;
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

    @Column(unique = true)
    private String name;

    @Column(unique = true)
    private String rg;

    @Column(unique = true)
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

    private Date registrationDate;

}
