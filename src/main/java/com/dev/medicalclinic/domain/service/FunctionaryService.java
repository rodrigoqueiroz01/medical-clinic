package com.dev.medicalclinic.domain.service;

import com.dev.medicalclinic.api.exception.DataAlreadyRegisteredException;
import com.dev.medicalclinic.api.exception.DataBadRequestException;
import com.dev.medicalclinic.api.exception.EntityNotFoundException;
import com.dev.medicalclinic.domain.entity.Functionary;
import com.dev.medicalclinic.domain.entity.enums.SchoolingType;
import com.dev.medicalclinic.domain.repository.FunctionaryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * @author rodrigoqueiroz
 */

@Service
@AllArgsConstructor
public class FunctionaryService {

    private static Logger log = Logger.getLogger(FunctionaryService.class.getName());

    private final FunctionaryRepository functionaryRepository;

    public Functionary save(Functionary functionary) {
        log.info("Criando um novo funcionário.");

        if (!Objects.isNull(functionaryRepository.findByName(functionary.getName())) ||
                !Objects.isNull(functionaryRepository.findByCpf(functionary.getCpf())) ||
                !Objects.isNull(functionaryRepository.findByRg(functionary.getRg()))) {
            throw new DataAlreadyRegisteredException("Conflito: Funcionário já existe na base de dados.");
        }

        if (functionary.getSchooling().equals(SchoolingType.FUNDAMENTAL_INCOMPLETO) ||
                functionary.getSchooling().equals(SchoolingType.FUNDAMENTAL_COMPLETO) ||
                functionary.getSchooling().equals(SchoolingType.MEDIO_INCOMPLETO)) {
            throw new DataBadRequestException("Deve ter ensino médio completo.");
        }

        return functionaryRepository.save(functionary);
    }

    public Page<Functionary> findAll(Pageable pageable, String name, String office) {
        log.info("Encontrando os funcionários pelos filtros 'name' e 'office'.");

        return this.functionaryRepository.findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!name.equals(null) && !name.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("name")),
                        "%" + name.toLowerCase() + "%"));
            }

            if (!office.equals(null) && !office.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("office")),
                        "%"+ office.toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[]{}));
        }, pageable);
    }

    public Functionary findById(Long id) {
        log.info("Encontrando o funcionário pelo uuid registrado.");

        return functionaryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado!"));
    }

    public Functionary update(Functionary functionary, Long id) {
        log.info("Atualizando um funcionário.");

        functionaryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado!"));
        functionary.setId(id);

        if (!Objects.isNull(functionaryRepository.findByName(functionary.getName())) ||
                !Objects.isNull(functionaryRepository.findByCpf(functionary.getCpf())) ||
                !Objects.isNull(functionaryRepository.findByRg(functionary.getRg()))) {
            throw new DataAlreadyRegisteredException("Conflito: Funcionário já existe na base de dados.");
        }

        if (functionary.getSchooling().equals(SchoolingType.FUNDAMENTAL_INCOMPLETO) ||
                functionary.getSchooling().equals(SchoolingType.FUNDAMENTAL_COMPLETO) ||
                functionary.getSchooling().equals(SchoolingType.MEDIO_INCOMPLETO)) {
            throw new DataBadRequestException("Deve ter ensino médio completo.");
        }

        return functionaryRepository.save(functionary);
    }

    public String delete(String name) {
        log.info("Excluindo um funcionário.");

        var collaborator = new Functionary();

        try {
            collaborator = functionaryRepository.findByName(name);
        } catch (Exception e) {
            throw new EntityNotFoundException("Funcionário não encontrado!");
        }

        functionaryRepository.delete(collaborator);

        return name;
    }

}
