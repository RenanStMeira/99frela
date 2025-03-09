package com.studs.demo.domain.content;

import com.studs.demo.cache.usecase.UsuarioCahceUseCase;
import com.studs.demo.domain.mapper.UsuarioMapper;
import com.studs.demo.domain.model.Usuario;
import com.studs.demo.domain.service.UsuarioService;
import com.studs.demo.domain.model.request.UsuarioRequest;
import com.studs.demo.domain.model.response.UsuarioResponse;
import org.springframework.stereotype.Component;

@Component
public class UsuarioContent {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioService usuarioService;
    private final UsuarioCahceUseCase usuarioCahceUseCase;

    public UsuarioContent(UsuarioMapper usuarioMapper, UsuarioService usuarioService, UsuarioCahceUseCase usuarioCahceUseCase) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioService = usuarioService;
        this.usuarioCahceUseCase = usuarioCahceUseCase;
    }

    public Usuario creteUsuarioContent(UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioService.createUsuario(usuarioMapper.toEntity(usuarioRequest));
        usuarioCahceUseCase.saveUsuarioCache(usuario);
        return usuario;
    }

    public UsuarioResponse getUsuarioIdContent(Long id) {
        return usuarioMapper.toResponse(usuarioService.getUsuarioById(id));
    }

    public UsuarioResponse getUsuarioByEmailContent(String email) {
        return usuarioMapper.toResponse(usuarioService.getUsuarioByEmail(email));
    }

    public UsuarioResponse updateUsuarioContent(UsuarioRequest usuarioRequest) {
        return usuarioMapper.toResponse(usuarioService.updateUsuario(usuarioMapper.toEntity(usuarioRequest)));
    }

    public void deleteUsuarioContent(Long id) {
        usuarioService.deleteUsuario(id);
    }
}
