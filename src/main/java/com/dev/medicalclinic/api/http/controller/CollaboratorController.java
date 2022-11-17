package com.dev.medicalclinic.api.http.controller;

import com.dev.medicalclinic.api.http.dto.request.CollaboratorRequest;
import com.dev.medicalclinic.api.http.dto.response.CollaboratorResponse;
import com.dev.medicalclinic.api.http.mapper.CollaboratorMapper;
import com.dev.medicalclinic.domain.model.Collaborator;
import com.dev.medicalclinic.domain.service.CollaboratorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/collaborator")
@AllArgsConstructor
@Validated
public class CollaboratorController {

    private final CollaboratorService collaboratorService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CollaboratorResponse> save(@Valid @RequestBody CollaboratorRequest collaboratorRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CollaboratorMapper.toResponse(collaboratorService.save(CollaboratorMapper.toModel(collaboratorRequest))));
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<Collaborator>> findAll(Pageable pageable,
                                                      @RequestParam(value = "name", required = false) String name,
                                                      @RequestParam(value = "office", required = false) String office) {
        return ResponseEntity.ok().body(collaboratorService.findAll(pageable, name, office));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CollaboratorResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(CollaboratorMapper.toResponse(collaboratorService.findById(Long.valueOf(id))));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CollaboratorResponse> update(@Valid @RequestBody CollaboratorRequest collaboratorRequest,
                                                       @PathVariable String id) {
        return ResponseEntity.ok().body(CollaboratorMapper.toResponse(collaboratorService.update(
                CollaboratorMapper.toModel(collaboratorRequest), Long.valueOf(id))));
    }

    @DeleteMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@PathVariable String name) {
        String collaborator = collaboratorService.delete(name);

        return ResponseEntity.ok().body("Colaborador " + collaborator + " deletado da base de dados.");
    }

}
