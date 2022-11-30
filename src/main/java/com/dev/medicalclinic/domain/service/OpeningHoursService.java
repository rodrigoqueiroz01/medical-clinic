package com.dev.medicalclinic.domain.service;

import com.dev.medicalclinic.api.exception.EntityNotFoundException;
import com.dev.medicalclinic.domain.entity.OpeningHours;
import com.dev.medicalclinic.domain.repository.OpeningHoursRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OpeningHoursService {

    private final OpeningHoursRepository openingHoursRepository;

    public OpeningHours save(OpeningHours openingHours) {
        return openingHoursRepository.save(openingHours);
    }

    public OpeningHours update(OpeningHours openingHours, UUID id) {
        openingHoursRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Clínica não encontrada na base de dados."));
        openingHours.setId(id);

        return openingHoursRepository.save(openingHours);
    }

    public List<OpeningHours> findClinicHours() {
        return openingHoursRepository.findAll();
    }

}
