package com.studs.demo.cache.usecase;

import com.studs.demo.cache.model.CacheModel;
import com.studs.demo.domain.model.Usuario;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UsuarioCahceUseCase implements IUsuarioCache {
    private final Map<String, Usuario> cache = new HashMap<>();

    @Override
    public CacheModel getUsuarioCache(String idUsuario) {
        Usuario usuario = cache.get(idUsuario);
        if (usuario != null) {
            return new CacheModel(usuario);
        }
        return null;
    }

    @Override
    public Usuario getUsuario(String idUsuario) {
        return cache.get(idUsuario);
    }

    @Override
    public void saveUsuarioCache(Usuario usuario) {
        cache.put(usuario.idUsuario().toString(), usuario);
    }
}