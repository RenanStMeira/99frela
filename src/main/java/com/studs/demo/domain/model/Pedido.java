package com.studs.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record Pedido(
        @JsonProperty("idPedido") Long idPedido,
        @JsonProperty("idUsuario") Long idUsuario,
        @JsonProperty("tipoServico") String tipoServico,
        @JsonProperty("enderecoOrigem") String enderecoOrigem,
        @JsonProperty("enderecoDestino") String enderecoDestino,
        @JsonProperty("dataHora") LocalDateTime dataHora,
        @JsonProperty("descricao") String descricao,
        @JsonProperty("status") String status // e.g., "pendente", "em andamento", "concluído", "cancelado"
) {}