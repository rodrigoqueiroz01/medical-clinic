package com.dev.medicalclinic.api.http.mapper;

import com.dev.medicalclinic.api.http.dto.request.FunctionaryRequest;
import com.dev.medicalclinic.api.http.dto.response.FunctionaryResponse;
import com.dev.medicalclinic.domain.entity.Functionary;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

/**
 * @author rodrigoqueiroz
 */

@Component
public class FunctionaryMapper {

    public static Functionary toModel(FunctionaryRequest functionaryRequest) {
        return Functionary
                .builder()
                .name(functionaryRequest.getName())
                .rg(functionaryRequest.getRg())
                .cpf(functionaryRequest.getCpf())
                .birthDate(functionaryRequest.getBirthDate())
                .age(functionaryRequest.getAge())
                .nameFather(functionaryRequest.getNameFather())
                .motherName(functionaryRequest.getMotherName())
                .personalPhone(functionaryRequest.getPersonalPhone())
                .corporatePhone(functionaryRequest.getCorporatePhone())
                .genre(functionaryRequest.getGenre())
                .schooling(functionaryRequest.getSchooling())
                .maritalStatus(functionaryRequest.getMaritalStatus())
                .email(functionaryRequest.getEmail())
                .address(functionaryRequest.getAddress())
                .collaborativeData(functionaryRequest.getCollaborativeData())
                .build();
    }

    public static FunctionaryResponse toResponse(Functionary functionary) {
        return FunctionaryResponse
                .builder()
                .id(functionary.getId())
                .name(functionary.getName())
                .rg(functionary.getRg())
                .cpf(functionary.getCpf())
                .birthDate(functionary.getBirthDate())
                .age(functionary.getAge())
                .nameFather(functionary.getNameFather())
                .motherName(functionary.getMotherName())
                .personalPhone(functionary.getPersonalPhone())
                .corporatePhone(functionary.getCorporatePhone())
                .genre(functionary.getGenre())
                .schooling(functionary.getSchooling())
                .maritalStatus(functionary.getMaritalStatus())
                .email(functionary.getEmail())
                .address(functionary.getAddress())
                .collaborativeData(functionary.getCollaborativeData())
                .registrationDate(functionary.getRegistrationDate())
                .build();
    }

    public static List<FunctionaryResponse> toResponseList(List<Functionary> functionaryList) {
        if (isNull(functionaryList) || functionaryList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return functionaryList.stream().map(FunctionaryMapper::toResponse).collect(Collectors.toList());
        }
    }

}
