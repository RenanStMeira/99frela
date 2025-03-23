package com.studs.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idPedido")
    private Long idPedido;
    @JsonProperty("idUsuario")
    private Long idUsuario;
    @JsonProperty("tipoServico")
    private String tipoServico;
    @JsonProperty("enderecoOrigem")
    private String enderecoOrigem;
    @JsonProperty("enderecoDestino")
    private String enderecoDestino;
    @JsonProperty("dataHora")
    private LocalDateTime dataHora;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("status")
    private String status;

    public Pedido(Long idPedido, Long idUsuario, String tipoServico, String enderecoOrigem, String enderecoDestino, LocalDateTime dataHora, String descricao, String status) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.tipoServico = tipoServico;
        this.enderecoOrigem = enderecoOrigem;
        this.enderecoDestino = enderecoDestino;
        this.dataHora = dataHora;
        this.descricao = descricao;
        this.status = status;
    }

    public Pedido() {

    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getEnderecoOrigem() {
        return enderecoOrigem;
    }

    public void setEnderecoOrigem(String enderecoOrigem) {
        this.enderecoOrigem = enderecoOrigem;
    }

    public String getEnderecoDestino() {
        return enderecoDestino;
    }

    public void setEnderecoDestino(String enderecoDestino) {
        this.enderecoDestino = enderecoDestino;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}