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
public class CollaborativeDataModel {

    @Column(name = "collaborative_office", nullable = false, length = 150)
    private String office;

    @Column(name = "collaborative_salary", nullable = false)
    private Double salary;

    @Column(name = "collaborative_meal_ticket", nullable = false)
    private Double mealTicket;

    @Column(name = "collaborative_transportation_vouchers", nullable = false)
    private Double transportationVouchers;

    @Column(name = "collaborative_work_job", nullable = false, length = 7)
    private String workJob;

    @Column(name = "collaborative_admission_date", length = 10)
    private String admissionDate;

    @Column(name = "collaborative_holiday_start_date", length = 10)
    private String holidayStartDate;

    @Column(name = "collaborative_holiday_end_date", length = 10)
    private String holidayEndDate;

    @Column(name = "collaborative_dismissal_date", length = 10)
    private String dismissalDate;

}
