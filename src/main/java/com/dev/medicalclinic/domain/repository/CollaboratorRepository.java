package com.dev.medicalclinic.domain.repository;

import com.dev.medicalclinic.domain.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {

    Collaborator findByName(String name);
    Collaborator findByCpf(String cpf);
    Collaborator findByRg(String rg);

}
