package com.studs.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Usuario(
        @JsonProperty("idUsuario") Long idUsuario,
        @JsonProperty("nome") String nome,
        @JsonProperty("email") String email,
        @JsonProperty("senha") String senha,
        @JsonProperty("telefone") String telefone,
        @JsonProperty("endereco") String endereco,
        @JsonProperty("status") String status // e.g., "pendente", "aprovado"
) {}