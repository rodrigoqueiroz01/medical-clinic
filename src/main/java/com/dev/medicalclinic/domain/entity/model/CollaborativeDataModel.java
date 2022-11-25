package com.dev.medicalclinic.domain.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

/**
 * @author rodrigoqueiroz
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CollaborativeDataModel {

    @Length(max = 255, message = "Respeite o limite máximo de 255 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "collaborative_office")
    private String office;

    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "collaborative_salary")
    private Double salary;

    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "collaborative_meal_ticket")
    private Double mealTicket;

    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "collaborative_transportation_vouchers")
    private Double transportationVouchers;

    @Length(max = 7, message = "Respeite o limite máximo de 7 caracteres.")
    @NotBlank(message = "Este campo é obrigatório.")
    @Column(name = "collaborative_work_job")
    private String workJob;

    @Length(min = 10, max = 10, message = "Respeite o limite máximo de 10 caracteres.")
    @Column(name = "collaborative_admission_date")
    private String admissionDate;

    @Length(min = 10, max = 10, message = "Respeite o limite máximo de 10 caracteres.")
    @Column(name = "collaborative_holiday_start_date")
    private String holidayStartDate;

    @Length(min = 10, max = 10, message = "Respeite o limite máximo de 10 caracteres.")
    @Column(name = "collaborative_holiday_end_date")
    private String holidayEndDate;

    @Length(min = 10, max = 10, message = "Respeite o limite máximo de 10 caracteres.")
    @Column(name = "collaborative_dismissal_date")
    private String dismissalDate;

}
