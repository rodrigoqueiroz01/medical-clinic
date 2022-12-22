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
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author rodrigoqueiroz
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FunctionaryResponse {

    // Functionary
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
    private GenreType genre;
    private SchoolingType schooling;
    private MaritalStatus maritalStatus;
    private String email;
    private AddressModel address;
    private CollaborativeDataModel collaborativeData;

    // AddressModel
    private String cep;
    private String street;
    private Integer number;
    private String complement;
    private String district;
    private String city;
    private String uf;
    private String nationality;

    // CollaborativeDataModel
    private String office;
    private Double salary;
    private Double mealTicket;
    private Double transportationVouchers;
    private String workJob;
    private String admissionDate;
    private String holidayStartDate;
    private String holidayEndDate;
    private String dismissalDate;
    private BankAccountResponse bankAccountResponse;

    // Functionary
    private LocalDate registrationDate;

}
