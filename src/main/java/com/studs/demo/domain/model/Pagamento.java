package com.studs.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Pagamento(
        @JsonProperty("idPagamento") Long idPagamento,
        @JsonProperty("idPedido") Long idPedido,
        @JsonProperty("idUsuario") Long idUsuario,
        @JsonProperty("valor") BigDecimal valor,
        @JsonProperty("dataHora") LocalDateTime dataHora,
        @JsonProperty("status") String status // e.g., "pendente", "aprovado", "recusado"
) {}