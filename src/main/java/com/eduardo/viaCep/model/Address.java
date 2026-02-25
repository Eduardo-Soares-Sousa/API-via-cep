package com.eduardo.viaCep.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("cep")
    private String zipCode;
    @JsonProperty("logradouro")
    private String street;
    @JsonProperty("complemento")
    private String complement;
    @JsonProperty("bairro")
    private String neighborhood;
    @JsonProperty("localidade")
    private String city;
    @JsonProperty("uf")
    private String state;
    @JsonProperty("ddd")
    private String areaCode;
}
