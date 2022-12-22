package com.dev.medicalclinic.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "opening_hours", schema = "public")
public class OpeningHours implements Serializable {

    @Serial
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    private Long id;

    @Column(name = "open_and", unique = true, nullable = false, length = 13)
    private String openAnd;

    @Column(name = "closes_in", unique = true, nullable = false, length = 13)
    private String closesIn;

    @Column(name = "opening_time", unique = true, nullable = false, length = 5)
    private String openingTime;

    @Column(name = "closing_time", unique = true, nullable = false, length = 5)
    private String closingTime;

}
