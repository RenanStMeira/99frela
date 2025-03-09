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
) {
    public Usuario {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }
        if (senha == null || senha.isBlank()) {
            throw new IllegalArgumentException("Senha não pode ser nulo ou vazio");
        }
        if (telefone == null || telefone.isBlank()) {
            throw new IllegalArgumentException("Telefone não pode ser nulo ou vazio");
        }
        if (endereco == null || endereco.isBlank()) {
            throw new IllegalArgumentException("Endereço não pode ser nulo ou vazio");
        }
        if (status == null || status.isBlank()) {
            throw new IllegalArgumentException("Status não pode ser nulo ou vazio");
        }
    }

    public Usuario(String nome, String email, String senha, String telefone, String endereco) {
        this(null, nome, email, senha, telefone, endereco, "aprovado");
    }
}