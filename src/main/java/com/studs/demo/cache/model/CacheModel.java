package com.studs.demo.cache.model;

import com.studs.demo.domain.model.Pedido;
import com.studs.demo.domain.model.Usuario;

public class CacheModel {
    private Usuario usuario;
    private Pedido pedido;

    public CacheModel(Usuario usuario) {
        this.usuario = usuario;
    }

    public CacheModel(Pedido pedido) {
        this.pedido = pedido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}