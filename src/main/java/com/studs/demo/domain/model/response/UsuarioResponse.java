package com.studs.demo.domain.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UsuarioResponse(
        @JsonProperty("idUsuario") Long idUsuario,
        @JsonProperty("nome") String nome,
        @JsonProperty("email") String email,
        @JsonProperty("telefone") String telefone,
        @JsonProperty("endereco") String endereco,
        @JsonProperty("status") String status // e.g., "pendente", "aprovado"
) {
}