package com.studs.demo.domain.model.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoRequest(
        Long idPedido,
        Long idUsuario,
        BigDecimal valor,
        LocalDateTime dataHora,
        String status
) {
}
