package com.dev.medicalclinic.api.http.controller;

import com.dev.medicalclinic.api.http.dto.request.FunctionaryRequest;
import com.dev.medicalclinic.api.http.dto.response.FunctionaryResponse;
import com.dev.medicalclinic.api.http.mapper.FunctionaryMapper;
import com.dev.medicalclinic.domain.entity.Functionary;
import com.dev.medicalclinic.domain.service.FunctionaryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

/**
 * @author rodrigoqueiroz
 */

@RestController
@RequestMapping("/functionary")
@AllArgsConstructor
@Validated
public class FunctionaryController {

    private final FunctionaryService functionaryService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FunctionaryResponse> save(@Valid @RequestBody FunctionaryRequest functionaryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(FunctionaryMapper.toResponse(functionaryService.save(FunctionaryMapper.toModel(functionaryRequest))));
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Functionary>> findAll(Pageable pageable,
                                                     @RequestParam(value = "name", required = false) String name,
                                                     @RequestParam(value = "office", required = false) String office) {
        return ResponseEntity.ok().body(functionaryService.findAll(pageable, name, office));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FunctionaryResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(FunctionaryMapper.toResponse(functionaryService.findById(UUID.fromString(id))));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FunctionaryResponse> update(@Valid @RequestBody FunctionaryRequest functionaryRequest,
                                                      @PathVariable String id) {
        return ResponseEntity.ok().body(FunctionaryMapper.toResponse(functionaryService.update(
                FunctionaryMapper.toModel(functionaryRequest), UUID.fromString(id))));
    }

    @DeleteMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@PathVariable String name) {
        String collaborator = functionaryService.delete(name);

        return ResponseEntity.ok().body("Colaborador " + collaborator + " deletado da base de dados.");
    }

}
