package com.dev.medicalclinic.api.http.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class OpeningHoursRequest {

    @Length(max = 13, message = "Respeite o limite máximo de 13 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String openAnd;

    @Length(max = 13, message = "Respeite o limite máximo de 13 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String closesIn;

    @Length(max = 5, message = "Respeite o limite máximo de 5 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String openingTime;

    @Length(max = 5, message = "Respeite o limite máximo de 5 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    private String closingTime;

}
