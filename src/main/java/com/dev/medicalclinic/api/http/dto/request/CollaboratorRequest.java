package com.dev.medicalclinic.api.http.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author rodrigoqueiroz
 */

@Getter
@Setter
public class CollaboratorRequest {

    @Size(max = 255, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo não pode ser vazio ou nulo.")
    private String name;

    @Size(min = 8, max = 9, message = "Respeite o limite mínimo de 8, e limite máximo de 9 caracteres.")
    @NotBlank(message = "Este campo não pode ser vazio ou nulo.")
    private String genre;

    @NotNull(message = "Este campo não pode ser nulo.")
    private Integer age;

    @Size(max = 10, message = "Respeite o limite máximo de 10 caracteres.")
    @NotBlank(message = "Este campo não pode ser vazio ou nulo.")
    private String rg;

    @CPF(message = "Informe o CPF correto. Ex.: 000.000.000-00")
    @Size(max = 14, message = "Respeite o limite máximo de 14 caracteres.")
    @NotBlank(message = "Este campo não pode ser vazio ou nulo.")
    private String cpf;

    @Size(max = 7, message = "Respeite o limite máximo de 7 caracteres.")
    @NotBlank(message = "Este campo não pode ser vazio ou nulo.")
    private String workCardNumber;

    @NotNull(message = "Este campo não pode ser nulo.")
    private Integer numberPis;

    @Size(max = 255, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo não pode ser vazio ou nulo.")
    private String office;

    @Size(max = 255, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo não pode ser vazio ou nulo.")
    private String nationality;

    @Size(max = 10, message = "Respeite o limite máximo de 10 caracteres.")
    @NotBlank(message = "Este campo não pode ser vazio ou nulo.")
    private String birthDate;

    @Size(max = 255, message = "Respeite o limite máximo de 255 caracteres.")
    private String nameFather;

    @Size(max = 255, message = "Respeite o limite máximo de 255 caracteres.")
    private String motherName;

    @Size(min = 11, max = 15, message = "Respeite o limite mínimo de 11, e limite máximo de 15 caracteres.")
    @NotBlank(message = "Este campo não pode ser vazio ou nulo.")
    private String personalPhone;

    @Size(min = 11, max = 15, message = "Respeite o limite mínimo de 11, e limite máximo de 15 caracteres.")
    @NotBlank(message = "Este campo não pode ser vazio ou nulo.")
    private String corporatePhone;

    @Size(max = 100, message = "Respeite o limite máximo de 100 caracteres.")
    @NotBlank(message = "Este campo não pode ser vazio ou nulo.")
    private String schooling;

    @Size(max = 100, message = "Respeite o limite máximo de 100 caracteres.")
    @NotBlank(message = "Este campo não pode ser vazio ou nulo.")
    private String maritalStatus;

    @Email(message = "Informe o e-mail correto. Ex.: exemplo@email.com")
    @Size(min = 11, max = 255, message = "Respeite o limite mínimo de 11, e limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo não pode ser vazio ou nulo.")
    private String email;

}
