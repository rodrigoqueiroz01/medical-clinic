package com.dev.medicalclinic.domain.repository;

import com.dev.medicalclinic.domain.entity.OpeningHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpeningHoursRepository extends JpaRepository<OpeningHours, Long> { }
