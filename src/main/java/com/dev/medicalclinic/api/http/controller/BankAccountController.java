package com.dev.medicalclinic.api.http.controller;

import com.dev.medicalclinic.api.http.dto.request.BankAccountRequest;
import com.dev.medicalclinic.api.http.dto.response.BankAccountResponse;
import com.dev.medicalclinic.api.http.mapper.BankAccountMapper;
import com.dev.medicalclinic.domain.service.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bank-account")
@AllArgsConstructor
@Validated
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BankAccountResponse> save(@Valid @RequestBody BankAccountRequest bankAccountRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(BankAccountMapper.toResponse(bankAccountService.save(BankAccountMapper.toModel(bankAccountRequest))));
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BankAccountResponse>> findAll() {
        return ResponseEntity.ok().body(BankAccountMapper.toResponseList(bankAccountService.findAll()));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BankAccountResponse> findById(@PathVariable String id) {
        return ResponseEntity.ok().body(BankAccountMapper.toResponse(bankAccountService.findById(UUID.fromString(id))));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BankAccountResponse> update(@Valid @RequestBody BankAccountRequest bankAccountRequest, @PathVariable String id) {
        return ResponseEntity.ok().body(BankAccountMapper.toResponse(bankAccountService.update(
                BankAccountMapper.toModel(bankAccountRequest), UUID.fromString(id))));
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> delete(@PathVariable String id) {
        String code = String.valueOf(bankAccountService.delete(UUID.fromString(id)));

        return ResponseEntity.ok().body("Conta bancária (cód. de registro: " + code + ") removida da base de dados.");
    }

}
