package com.studs.demo.domain.model.response;

public record ServicoResponse(
        Long idServico,
        String nome,
        String descricao,
        Number preco
) {
}
