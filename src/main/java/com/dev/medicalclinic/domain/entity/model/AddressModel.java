package com.dev.medicalclinic.domain.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author rodrigoqueiroz
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AddressModel {

    @Length(max = 9, message = "Respeite o limite máximo de 9 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "address_cep")
    private String cep;

    @Length(max = 255, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "address_street")
    private String street;

    // pode dar um erro aqui
    @NotNull(message = "Este campo é obrigatório.")
    @Column(name = "address_number")
    private Integer number;

    @Length(max = 255, message = "Respeite o limite máximo de 255 caracteres.")
    @Column(name = "address_complement")
    private String complement;

    @Length(max = 255, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "address_district")
    private String district;

    @Length(max = 255, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "address_city")
    private String city;

    @Length(max = 2, message = "Respeite o limite máximo de 2 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "address_uf")
    private String uf;

    @Length(max = 255, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "address_nationality")
    private String nationality;

}
