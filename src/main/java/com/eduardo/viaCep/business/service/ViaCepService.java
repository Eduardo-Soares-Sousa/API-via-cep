package com.eduardo.viaCep.service;

import com.eduardo.viaCep.model.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {
    private final RestTemplate restTemplate = new RestTemplate();

    public Address findAddress(String zipCode) {
        String cleanZipCode = zipCode.replace("[^0-9]", "");


    }

    private void validateZipCode(String zipCode) {
        if(zipCode == null || zipCode.matches("\\d{8}")) {
            throw new InvalidZipCodeException("Invalid ZIP code. Must contain 8 numeric digits.");
        }
    }
}
