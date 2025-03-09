package com.studs.demo.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record Servico(
        @JsonProperty("idServico") Long idServico,
        @JsonProperty("nome") String nome,
        @JsonProperty("descricao") String descricao,
        @JsonProperty("preco") BigDecimal preco
) {}