package com.dev.medicalclinic.domain.repository;

import com.dev.medicalclinic.domain.entity.Functionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author rodrigoqueiroz
 */

@Repository
public interface FunctionaryRepository extends JpaRepository<Functionary, UUID>, JpaSpecificationExecutor {

    Functionary findByName(String name);

    Functionary findByCpf(String cpf);

    Functionary findByRg(String rg);

}
