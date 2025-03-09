package com.studs.demo.domain.mapper;

import com.studs.demo.domain.model.Usuario;
import com.studs.demo.domain.model.request.UsuarioRequest;
import com.studs.demo.domain.model.response.UsuarioResponse;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getEndereco(),
                usuario.getStatus()
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
