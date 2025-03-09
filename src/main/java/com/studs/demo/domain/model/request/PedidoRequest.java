package com.studs.demo.domain.model.request;

import java.time.LocalDateTime;

public record PedidoRequest(
        Long idUsuario,
        String tipoServico,
        String enderecoOrigem,
        String enderecoDestino,
        String descricao,
        LocalDateTime dataHora,
        String status
) {
}
