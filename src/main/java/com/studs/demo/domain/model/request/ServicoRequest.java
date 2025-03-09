package com.studs.demo.domain.model.request;

public record ServicoRequest(
        String nome,
        String descricao,
        Number preco
) {
}
