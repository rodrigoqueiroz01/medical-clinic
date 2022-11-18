package com.dev.medicalclinic.domain.repository;

import com.dev.medicalclinic.domain.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author rodrigoqueiroz
 */

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long>, JpaSpecificationExecutor {

    Collaborator findByName(String name);
    Collaborator findByCpf(String cpf);
    Collaborator findByRg(String rg);

}
