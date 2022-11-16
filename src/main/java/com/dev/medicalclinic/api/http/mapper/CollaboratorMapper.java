package com.dev.medicalclinic.api.http.mapper;

import com.dev.medicalclinic.api.http.dto.request.CollaboratorRequest;
import com.dev.medicalclinic.api.http.dto.response.CollaboratorResponse;
import com.dev.medicalclinic.domain.model.Collaborator;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class CollaboratorMapper {

    public static Collaborator toModel(CollaboratorRequest collaboratorRequest) {
        return Collaborator
                .builder()
                .name(collaboratorRequest.getName())
                .genre(collaboratorRequest.getGenre())
                .age(collaboratorRequest.getAge())
                .rg(collaboratorRequest.getRg())
                .cpf(collaboratorRequest.getCpf())
                .workCardNumber(collaboratorRequest.getWorkCardNumber())
                .numberPis(collaboratorRequest.getNumberPis())
                .office(collaboratorRequest.getOffice())
                .nationality(collaboratorRequest.getNationality())
                .birthDate(collaboratorRequest.getBirthDate())
                .nameFather(collaboratorRequest.getNameFather())
                .motherName(collaboratorRequest.getMotherName())
                .personalPhone(collaboratorRequest.getPersonalPhone())
                .schooling(collaboratorRequest.getSchooling())
                .maritalStatus(collaboratorRequest.getMaritalStatus())
                .email(collaboratorRequest.getEmail())
                .build();
    }

    public static CollaboratorResponse toResponse(Collaborator collaborator) {
        return CollaboratorResponse
                .builder()
                .id(collaborator.getId())
                .name(collaborator.getName())
                .genre(collaborator.getGenre())
                .age(collaborator.getAge())
                .rg(collaborator.getRg())
                .cpf(collaborator.getCpf())
                .workCardNumber(collaborator.getWorkCardNumber())
                .numberPis(collaborator.getNumberPis())
                .office(collaborator.getOffice())
                .nationality(collaborator.getNationality())
                .birthDate(collaborator.getBirthDate())
                .nameFather(collaborator.getNameFather())
                .motherName(collaborator.getMotherName())
                .personalPhone(collaborator.getPersonalPhone())
                .schooling(collaborator.getSchooling())
                .maritalStatus(collaborator.getMaritalStatus())
                .email(collaborator.getEmail())
                .build();
    }

    public static List<CollaboratorResponse> toResponseList(List<Collaborator> collaboratorList) {
        if (isNull(collaboratorList) || collaboratorList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return collaboratorList.stream().map(CollaboratorMapper::toResponse).collect(Collectors.toList());
        }
    }

}
