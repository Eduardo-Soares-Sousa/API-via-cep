package com.eduardo.viaCep.controller;

import com.eduardo.viaCep.business.service.ViaCepService;
import com.eduardo.viaCep.model.Address;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("viaCep")
@RequiredArgsConstructor
public class ViaCepController {
    private final ViaCepService viaCepService;

    @Operation(summary = "find address", description = "Find the address by passing the zip code as a parameter")
    @ApiResponse(responseCode = "200", description = "Address found successfully")
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "500", description = "Server error")
    @GetMapping("/{cep}")
    public ResponseEntity<Address> findAddress(@RequestParam String cep) {
        return ResponseEntity.ok(viaCepService.findAddress(cep));
    }
}
