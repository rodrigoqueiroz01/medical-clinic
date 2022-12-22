package com.dev.medicalclinic.domain.service;

import com.dev.medicalclinic.api.exception.EntityNotFoundException;
import com.dev.medicalclinic.domain.entity.OpeningHours;
import com.dev.medicalclinic.domain.repository.OpeningHoursRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class OpeningHoursService {

    private static Logger log = Logger.getLogger(OpeningHoursService.class.getName());

    private final OpeningHoursRepository openingHoursRepository;

    public OpeningHours save(OpeningHours openingHours) {
        log.info("Salvando o horário de funcionamento da clínica.");

        return openingHoursRepository.save(openingHours);
    }

    public OpeningHours update(OpeningHours openingHours, Long id) {
        log.info("Atualizando o horário de funcionamento da clínica.");

        openingHoursRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Clínica não encontrada na base de dados."));
        openingHours.setId(id);

        return openingHoursRepository.save(openingHours);
    }

    public List<OpeningHours> findClinicHours() {
        log.info("Consultando o horário de funcionamento da clínica.");

        return openingHoursRepository.findAll();
    }

}
