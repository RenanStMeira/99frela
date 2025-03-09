package com.studs.demo.cache.model;

import com.studs.demo.domain.model.Usuario;

public class CacheModel {
    private Usuario usuario;

    public CacheModel(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}