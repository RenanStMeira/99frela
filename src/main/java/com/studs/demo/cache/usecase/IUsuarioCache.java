package com.studs.demo.cache.usecase;

import com.studs.demo.cache.model.CacheModel;
import com.studs.demo.domain.model.Usuario;

public interface IUsuarioCache {
    CacheModel getUsuarioCache(String idUsuario);
    Usuario getUsuario(String idUsuario);
    void saveUsuarioCache(Usuario usuario);
}
