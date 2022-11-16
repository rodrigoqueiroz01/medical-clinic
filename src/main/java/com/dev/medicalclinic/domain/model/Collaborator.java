package com.dev.medicalclinic.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "collaborator")
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

    @Column(unique = true)
    private String rg;

    @Column(unique = true)
    private String cpf;

    @Column(name = "work_card_number")
    private String workCardNumber;

    private Integer numberPis;

    private String office;

    private String nationality;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "name_father")
    private String nameFather;

    @Column(name = "mother_name")
    private String motherName;

    @Column(name = "personal_phone")
    private String personalPhone;

    @Column(name = "corporate_phone")
    private String corporatePhone;

    private String schooling;

    @Column(name = "marital_status")
    private String maritalStatus;

    private String email;

}
