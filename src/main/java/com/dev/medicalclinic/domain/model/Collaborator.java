package com.dev.medicalclinic.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

/**
 * @author rodrigoqueiroz
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "collaborator", schema = "public")
public class Collaborator implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    private String genre;

    private Integer age;

    @Embedded
    private Address address;

    @Column(unique = true)
    private String rg;

    @Column(unique = true)
    private String cpf;

    private String workCardNumber;

    private Integer numberPis;

    private String office;

    private String birthDate;

    private String nameFather;

    private String motherName;

    private String personalPhone;

    private String corporatePhone;

    private String schooling;

    private String maritalStatus;

    private String email;

}
