package com.dev.medicalclinic.domain.service;

import com.dev.medicalclinic.api.exception.DataAlreadyRegisteredException;
import com.dev.medicalclinic.api.exception.DataNotFoundException;
import com.dev.medicalclinic.domain.model.Collaborator;
import com.dev.medicalclinic.domain.repository.CollaboratorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
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

    public List<Collaborator> findAll() {
        return collaboratorRepository.findAll();
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
