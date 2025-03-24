package com.studs.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idUsuario")
    private Long idUsuario;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("email")
    private String email;

    private String senha;

    @JsonProperty("telefone")
    private String telefone;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("status")
    private String status; // e.g., "pendente", "aprovado"

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nome, String email, String senha, String telefone, String endereco, String status) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
        this.status = status;
    }

    public Usuario(String nome, String email, String senha, String telefone, String endereco) {
        this(null, nome, email, senha, telefone, endereco, "aprovado");
    }

    // Getters and setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}