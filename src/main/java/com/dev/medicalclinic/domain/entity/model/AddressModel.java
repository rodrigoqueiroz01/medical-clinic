package com.dev.medicalclinic.domain.entity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author rodrigoqueiroz
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AddressModel {

    @Column(name = "address_cep", nullable = false, length = 9)
    private String cep;

    @Column(name = "address_street", nullable = false)
    private String street;

    @Column(name = "address_number", nullable = false)
    private Integer number;

    @Column(name = "address_complement")
    private String complement;

    @Column(name = "address_district", nullable = false, length = 150)
    private String district;

    @Column(name = "address_city", nullable = false, length = 200)
    private String city;

    @Column(name = "address_uf", nullable = false, length = 2)
    private String uf;

    @Column(name = "address_nationality", nullable = false, length = 150)
    private String nationality;

}
