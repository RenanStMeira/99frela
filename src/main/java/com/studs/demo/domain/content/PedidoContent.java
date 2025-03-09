package com.studs.demo.domain.content;

import com.studs.demo.cache.usecase.PedidoUseCaseCache;
import com.studs.demo.domain.mapper.PedidoMapper;
import com.studs.demo.domain.model.Pedido;
import com.studs.demo.domain.model.request.PedidoRequest;
import com.studs.demo.domain.service.PedidoService;
import org.springframework.stereotype.Component;

@Component
public class PedidoContent {

    private final PedidoMapper mapper;
    private final PedidoService service;
    private final PedidoUseCaseCache cache;

    public PedidoContent(PedidoMapper mapper, PedidoService service, PedidoUseCaseCache cache) {
        this.mapper = mapper;
        this.service = service;
        this.cache = cache;
    }

    public Pedido createPedidoContent(PedidoRequest pedidoRequest) {
        Pedido pedido = service.createPedido(mapper.toEntity(pedidoRequest));
        cache.savePedidoCache(pedido);
        return pedido;
    }

    public Pedido getPedidoByIdContent(Long id) {
        return service.getPedidoById(id);
    }

    public Pedido updatePedidoContent(PedidoRequest pedidoRequest) {
        return service.updatePedido(mapper.toEntity(pedidoRequest));
    }

    public void deletePedidoContent(Long id) {
        service.deletePedido(id);
    }
}
