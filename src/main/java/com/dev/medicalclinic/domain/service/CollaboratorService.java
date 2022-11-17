package com.dev.medicalclinic.domain.service;

import com.dev.medicalclinic.api.exception.DataAlreadyRegisteredException;
import com.dev.medicalclinic.api.exception.DataNotFoundException;
import com.dev.medicalclinic.domain.model.Collaborator;
import com.dev.medicalclinic.domain.repository.CollaboratorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class CollaboratorService {

    private final CollaboratorRepository collaboratorRepository;

    public Collaborator save(Collaborator collaborator) {
        if (!Objects.isNull(collaboratorRepository.findByName(collaborator.getName())) ||
                !Objects.isNull(collaboratorRepository.findByCpf(collaborator.getCpf())) ||
                !Objects.isNull(collaboratorRepository.findByRg(collaborator.getRg()))) {
            throw new DataAlreadyRegisteredException("Conflito: Funcionário já existe na base de dados.");
        }

        return collaboratorRepository.save(collaborator);
    }

    public Page<Collaborator> findAll(Pageable pageable, String name, String office) {
        return this.collaboratorRepository.findAll((root, query, builder) -> {
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

    public Collaborator findById(Long id) {
        return collaboratorRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Colaborador não encontrado!"));
    }

    public Collaborator update(Collaborator collaborator, Long id) {
        collaboratorRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Colaborador não encontrado!"));
        collaborator.setId(id);

        if (!Objects.isNull(collaboratorRepository.findByName(collaborator.getName())) ||
                !Objects.isNull(collaboratorRepository.findByCpf(collaborator.getCpf())) ||
                !Objects.isNull(collaboratorRepository.findByRg(collaborator.getRg()))) {
            throw new DataAlreadyRegisteredException("Conflito: Funcionário já existe na base de dados.");
        }

        return collaboratorRepository.save(collaborator);
    }

    public String delete(String name) {
        Collaborator collaborator = new Collaborator();

        try {
            collaborator = collaboratorRepository.findByName(name);
        } catch (Exception e) {
            throw new DataAlreadyRegisteredException("Conflito: Funcionário já existe na base de dados.");
        }

        collaboratorRepository.delete(collaborator);

        return name;
    }

}
