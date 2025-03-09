package com.studs.demo.cache.usecase;

import com.studs.demo.cache.model.CacheModel;
import com.studs.demo.cache.usecase.interfaces.IPedidoCache;
import com.studs.demo.domain.model.Pedido;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PedidoUseCaseCache implements IPedidoCache {
    private final Map<String, Pedido> cache = new HashMap<>();

    @Override
    public CacheModel getPedidoCache(String idPedido) {
        Pedido pedido = cache.get(idPedido);
        if(pedido != null) {
            return new CacheModel(pedido);
        }
        return null;
    }

    @Override
    public Pedido getPedido(String idPedido) {
        return cache.get(idPedido);
    }

    @Override
    public void savePedidoCache(Pedido pedido) {
        cache.put(pedido.getIdPedido().toString(), pedido);
    }
}
