package com.dev.medicalclinic.api.http.controller;

import com.dev.medicalclinic.api.http.dto.request.OpeningHoursRequest;
import com.dev.medicalclinic.api.http.dto.response.OpeningHoursResponse;
import com.dev.medicalclinic.api.http.mapper.OpeningHoursMapper;
import com.dev.medicalclinic.domain.service.OpeningHoursService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/opening-hours/v1")
@AllArgsConstructor
@Validated
public class OpeningHoursController {

    private final OpeningHoursService openingHoursService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OpeningHoursResponse> save(@Valid @RequestBody OpeningHoursRequest openingHoursRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(OpeningHoursMapper.toResponse(openingHoursService.save(
                OpeningHoursMapper.toModel(openingHoursRequest))));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OpeningHoursResponse> update(@Valid @RequestBody OpeningHoursRequest openingHoursRequest,
                                                       @PathVariable String id) {
        return ResponseEntity.ok().body(OpeningHoursMapper.toResponse(openingHoursService.update(
                OpeningHoursMapper.toModel(openingHoursRequest), Long.valueOf(id))));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OpeningHoursResponse>> findClinicHours() {
        return ResponseEntity.ok().body(OpeningHoursMapper.toResponseList(openingHoursService.findClinicHours()));
    }

}
