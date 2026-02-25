package com.eduardo.viaCep.business.service;

import com.eduardo.viaCep.business.exceptions.InvalidZipCodeException;
import com.eduardo.viaCep.business.exceptions.ServiceUnavailableException;
import com.eduardo.viaCep.business.exceptions.ZipCodeNotFoundException;
import com.eduardo.viaCep.model.Address;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepService {
    private final RestTemplate restTemplate = new RestTemplate();

    public Address findAddress(String zipCode) {
        validateZipCode(zipCode);

        try {
            String url = "https://viacep.com.br/ws/" + zipCode + "/json/";

            Address address = restTemplate.getForObject(url, Address.class);

            if(address == null) {
                throw new ServiceUnavailableException("Service unavailable. API is not responding.");
            }

            if(Boolean.TRUE.equals(address.getError())) {
                throw new ZipCodeNotFoundException("Zip code not found.");
            }

            return address;
        }catch(RestClientException exception) {
            throw new ServiceUnavailableException("Communication error with the API viaCep");
        }
    }

    private void validateZipCode(String zipCode) {
        if(zipCode == null || zipCode.matches("\\d{8}")) {
            throw new InvalidZipCodeException("Invalid ZIP code. Must contain 8 numeric digits.");
        }
    }
}
