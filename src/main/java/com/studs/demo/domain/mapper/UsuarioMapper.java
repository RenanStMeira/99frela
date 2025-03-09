package com.studs.demo.domain.mapper;

import com.studs.demo.domain.model.Usuario;
import com.studs.demo.domain.usuario.request.UsuarioRequest;
import com.studs.demo.domain.usuario.response.UsuarioResponse;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.idUsuario(),
                usuario.nome(),
                usuario.email(),
                usuario.telefone(),
                usuario.endereco(),
                usuario.status()
        );
    }

    public Usuario toEntity(UsuarioRequest usuarioRequest) {
        return new Usuario(
                usuarioRequest.nome(),
                usuarioRequest.email(),
                usuarioRequest.senha(),
                usuarioRequest.telefone(),
                usuarioRequest.endereco()
        );
    }
}
