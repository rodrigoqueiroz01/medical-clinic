package com.dev.medicalclinic.api.http.dto.response;

import com.dev.medicalclinic.domain.entity.enums.GenreType;
import com.dev.medicalclinic.domain.entity.enums.MaritalStatus;
import com.dev.medicalclinic.domain.entity.enums.SchoolingType;
import com.dev.medicalclinic.domain.entity.model.AddressModel;
import com.dev.medicalclinic.domain.entity.model.CollaborativeDataModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.UUID;

/**
 * @author rodrigoqueiroz
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FunctionaryResponse {

    private UUID id;
    private String name;
    private String rg;
    private String cpf;
    private String birthDate;
    private Integer age;
    private String nameFather;
    private String motherName;
    private String personalPhone;
    private String corporatePhone;
    private GenreType genre;
    private SchoolingType schooling;
    private MaritalStatus maritalStatus;
    private String email;
    private AddressModel address;
    private CollaborativeDataModel collaborativeData;
    private Date registrationDate;

}
