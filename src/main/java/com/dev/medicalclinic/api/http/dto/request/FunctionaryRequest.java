package com.dev.medicalclinic.api.http.dto.request;

import com.dev.medicalclinic.domain.entity.enums.GenreType;
import com.dev.medicalclinic.domain.entity.enums.MaritalStatus;
import com.dev.medicalclinic.domain.entity.enums.SchoolingType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

/**
 * @author rodrigoqueiroz
 */

@Getter
@Setter
public class FunctionaryRequest {

    // Functionary
    @Length(max = 150, message = "Respeite o limite máximo de 150 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String name;

    @Length(max = 11, message = "Respeite o limite máximo de 11 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String rg;

    @CPF(message = "Informe um CPF válido. Ex.: 000.000.000-00")
    @Length(min = 11, max = 14, message = "Respeite o limite mínimo de 11, e máximo de 14 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String cpf;

    @Length(min = 10, max = 10, message = "Respeite o limite de 10 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String birthDate;

    @NotNull(message = "Este campo é obrigatório.")
    private Integer age;

    @Length(max = 150, message = "Respeite o limite máximo de 150 caracteres.")
    private String nameFather;

    @Length(max = 150, message = "Respeite o limite máximo de 150 caracteres.")
    private String motherName;

    @Length(min = 11, max = 15, message = "Respeite o limite mínimo de 11, e máximo de 15 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String personalPhone;

    @Length(min = 11, max = 15, message = "Respeite o limite mínimo de 11, e máximo de 15 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String corporatePhone;

    @NotNull(message = "Este campo é obrigatório.")
    private GenreType genre;

    @NotNull(message = "Este campo é obrigatório.")
    private SchoolingType schooling;

    @NotNull(message = "Este campo é obrigatório.")
    private MaritalStatus maritalStatus;

    @Email(message = "Informe um email válido. Ex.: exemplo@email.com")
    @Length(min = 10, max = 150, message = "Respeite o limite mínimo de 10, e máximo de 150 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String email;

    // AddressModel
    @Length(max = 9, message = "Respeite o limite máximo de 9 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String cep;

    @Length(max = 255, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String street;

    @NotNull(message = "Este campo é obrigatório.")
    private Integer number;

    @Length(max = 255, message = "Respeite o limite máximo de 255 caracteres.")
    private String complement;

    @Length(max = 150, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String district;

    @Length(max = 200, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String city;

    @Length(max = 2, message = "Respeite o limite máximo de 2 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String uf;

    @Length(max = 150, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String nationality;

    // CollaborativeDataModel
    @Length(max = 150, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String office;

    @NotBlank(message = "Este campo é obrigatório.")
    private Double salary;

    @NotBlank(message = "Este campo é obrigatório.")
    private Double mealTicket;

    @NotBlank(message = "Este campo é obrigatório.")
    private Double transportationVouchers;

    @Length(max = 7, message = "Respeite o limite máximo de 7 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String workJob;

    @Length(min = 10, max = 10, message = "Respeite o limite máximo de 10 caracteres.")
    private String admissionDate;

    @Length(min = 10, max = 10, message = "Respeite o limite máximo de 10 caracteres.")
    private String holidayStartDate;

    @Length(min = 10, max = 10, message = "Respeite o limite máximo de 10 caracteres.")
    private String holidayEndDate;

    @Length(min = 10, max = 10, message = "Respeite o limite máximo de 10 caracteres.")
    private String dismissalDate;

    @NotBlank(message = "Este campo é obrigatório.")
    private Long bankAccountId;

    // Functionary
    private LocalDate registrationDate;

}
