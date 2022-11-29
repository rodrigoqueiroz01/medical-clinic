package com.dev.medicalclinic.domain.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

/**
 * @author rodrigoqueiroz
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CollaborativeDataModel {

    @Length(max = 150, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "collaborative_office", nullable = false, length = 150)
    private String office;

    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "collaborative_salary", nullable = false)
    private Double salary;

    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "collaborative_meal_ticket", nullable = false)
    private Double mealTicket;

    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "collaborative_transportation_vouchers", nullable = false)
    private Double transportationVouchers;

    @Length(max = 7, message = "Respeite o limite máximo de 7 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "collaborative_work_job", nullable = false, length = 7)
    private String workJob;

    @Length(min = 10, max = 10, message = "Respeite o limite máximo de 10 caracteres.")
    @Column(name = "collaborative_admission_date", length = 10)
    private String admissionDate;

    @Length(min = 10, max = 10, message = "Respeite o limite máximo de 10 caracteres.")
    @Column(name = "collaborative_holiday_start_date", length = 10)
    private String holidayStartDate;

    @Length(min = 10, max = 10, message = "Respeite o limite máximo de 10 caracteres.")
    @Column(name = "collaborative_holiday_end_date", length = 10)
    private String holidayEndDate;

    @Length(min = 10, max = 10, message = "Respeite o limite máximo de 10 caracteres.")
    @Column(name = "collaborative_dismissal_date", length = 10)
    private String dismissalDate;

}
