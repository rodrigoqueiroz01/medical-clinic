package com.dev.medicalclinic.api.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rodrigoqueiroz
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CollaboratorResponse {

    private Long id;
    private String name;
    private String genre;
    private Integer age;
    private String rg;
    private String cpf;
    private String workCardNumber;
    private Integer numberPis;
    private String office;
    private String nationality;
    private String birthDate;
    private String nameFather;
    private String motherName;
    private String personalPhone;
    private String corporatePhone;
    private String schooling;
    private String maritalStatus;
    private String email;

}
