package com.studs.demo.domain.model.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoResponse(
        Long idPagamento,
        Long idPedido,
        Long idUsuario,
        BigDecimal valor,
        LocalDateTime dataHora,
        String status
) {
}
