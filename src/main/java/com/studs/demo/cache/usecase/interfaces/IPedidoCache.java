package com.studs.demo.cache.usecase.interfaces;

import com.studs.demo.cache.model.CacheModel;
import com.studs.demo.domain.model.Pedido;

public interface IPedidoCache {
    CacheModel getPedidoCache(String idPedido);
    Pedido getPedido(String idPedido);
    void savePedidoCache(Pedido pedido);
}
