package com.dev.medicalclinic.api.http.mapper;

import com.dev.medicalclinic.api.http.dto.request.OpeningHoursRequest;
import com.dev.medicalclinic.api.http.dto.response.OpeningHoursResponse;
import com.dev.medicalclinic.domain.entity.OpeningHours;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class OpeningHoursMapper {

    public static OpeningHours toModel(OpeningHoursRequest openingHoursRequest) {
        return OpeningHours
                .builder()
                .openAnd(openingHoursRequest.getOpenAnd())
                .closesIn(openingHoursRequest.getClosesIn())
                .openingTime(openingHoursRequest.getOpeningTime())
                .closingTime(openingHoursRequest.getClosingTime())
                .build();
    }

    public static OpeningHoursResponse toResponse(OpeningHours openingHours) {
        return OpeningHoursResponse
                .builder()
                .openAnd(openingHours.getOpenAnd())
                .closesIn(openingHours.getClosesIn())
                .openingTime(openingHours.getOpeningTime())
                .closingTime(openingHours.getClosingTime())
                .build();
    }

    public static List<OpeningHoursResponse> toResponseList(List<OpeningHours> openingHoursList) {
        if (Objects.isNull(openingHoursList) || openingHoursList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return openingHoursList.stream().map(OpeningHoursMapper::toResponse).collect(Collectors.toList());
        }
    }

}
