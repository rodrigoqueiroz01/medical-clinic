package com.dev.medicalclinic.api.http.mapper;

import com.dev.medicalclinic.api.http.dto.request.FunctionaryRequest;
import com.dev.medicalclinic.api.http.dto.response.FunctionaryResponse;
import com.dev.medicalclinic.domain.entity.BankAccount;
import com.dev.medicalclinic.domain.entity.Functionary;
import com.dev.medicalclinic.domain.entity.model.AddressModel;
import com.dev.medicalclinic.domain.entity.model.CollaborativeDataModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
                .address(AddressModel
                        .builder()
                        .cep(functionaryRequest.getCep())
                        .street(functionaryRequest.getStreet())
                        .number(functionaryRequest.getNumber())
                        .complement(functionaryRequest.getComplement())
                        .district(functionaryRequest.getDistrict())
                        .city(functionaryRequest.getCity())
                        .uf(functionaryRequest.getUf())
                        .nationality(functionaryRequest.getNationality())
                        .build())
                .collaborativeData(CollaborativeDataModel
                        .builder()
                        .office(functionaryRequest.getOffice())
                        .salary(functionaryRequest.getSalary())
                        .mealTicket(functionaryRequest.getMealTicket())
                        .transportationVouchers(functionaryRequest.getTransportationVouchers())
                        .workJob(functionaryRequest.getWorkJob())
                        .admissionDate(functionaryRequest.getAdmissionDate())
                        .holidayStartDate(functionaryRequest.getHolidayStartDate())
                        .holidayEndDate(functionaryRequest.getHolidayEndDate())
                        .dismissalDate(functionaryRequest.getDismissalDate())
                        .build())
                .bankAccount(BankAccount.builder().id(functionaryRequest.getBankAccountId()).build())
                .registrationDate(functionaryRequest.getRegistrationDate())
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
                .address(AddressModel
                        .builder()
                        .cep(functionary.getAddress().getCep())
                        .street(functionary.getAddress().getStreet())
                        .number(functionary.getAddress().getNumber())
                        .complement(functionary.getAddress().getComplement())
                        .district(functionary.getAddress().getDistrict())
                        .city(functionary.getAddress().getCity())
                        .uf(functionary.getAddress().getUf())
                        .nationality(functionary.getAddress().getNationality())
                        .build())
                .collaborativeData(CollaborativeDataModel
                        .builder()
                        .office(functionary.getCollaborativeData().getOffice())
                        .salary(functionary.getCollaborativeData().getSalary())
                        .mealTicket(functionary.getCollaborativeData().getMealTicket())
                        .transportationVouchers(functionary.getCollaborativeData().getTransportationVouchers())
                        .workJob(functionary.getCollaborativeData().getWorkJob())
                        .admissionDate(functionary.getCollaborativeData().getAdmissionDate())
                        .holidayStartDate(functionary.getCollaborativeData().getHolidayStartDate())
                        .holidayEndDate(functionary.getCollaborativeData().getHolidayEndDate())
                        .dismissalDate(functionary.getCollaborativeData().getDismissalDate())
                        .build())
                .bankAccountResponse(BankAccountMapper.toResponse(functionary.getBankAccount()))
                .registrationDate(functionary.getRegistrationDate())
                .build();
    }

    public static List<FunctionaryResponse> toResponseList(List<Functionary> functionaryList) {
        if (Objects.isNull(functionaryList) || functionaryList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return functionaryList.stream().map(FunctionaryMapper::toResponse).collect(Collectors.toList());
        }
    }

}
