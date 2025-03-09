package com.studs.demo.domain.mapper;

import com.studs.demo.domain.model.Pedido;
import com.studs.demo.domain.model.request.PedidoRequest;
import com.studs.demo.domain.model.response.PedidoResponse;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class PedidoMapper {

    public PedidoResponse toResponse(Pedido pedido) {
        return new PedidoResponse(
                pedido.getIdPedido(),
                pedido.getIdUsuario(),
                pedido.getTipoServico(),
                pedido.getEnderecoOrigem(),
                pedido.getEnderecoDestino(),
                pedido.getDescricao(),
                pedido.getStatus()
        );
    }

    public Pedido toEntity(PedidoRequest pedidoRequest) {
        return new Pedido(
                pedidoRequest.idUsuario(),
                Long.parseLong(pedidoRequest.tipoServico()),
                pedidoRequest.enderecoOrigem(),
                pedidoRequest.enderecoDestino(),
                pedidoRequest.descricao(),
                pedidoRequest.dataHora(),
                pedidoRequest.descricao(),
                pedidoRequest.status()
        );
    }
}