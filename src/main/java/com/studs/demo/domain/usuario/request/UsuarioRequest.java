package com.studs.demo.domain.usuario.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UsuarioRequest(
        @JsonProperty("nome") String nome,
        @JsonProperty("email") String email,
        @JsonProperty("senha") String senha,
        @JsonProperty("telefone") String telefone,
        @JsonProperty("endereco") String endereco
) {
}
