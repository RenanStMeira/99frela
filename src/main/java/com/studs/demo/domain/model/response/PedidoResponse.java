package com.studs.demo.domain.model.response;

public record PedidoResponse(
        Long idPedido,
        Long idUsuario,
        String tipoServico,
        String enderecoOrigem,
        String enderecoDestino,
        String descricao,
        String status // e.g., "pendente", "aprovado"
) {
}
