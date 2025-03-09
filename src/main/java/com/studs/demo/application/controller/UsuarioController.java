package com.studs.demo.application.controller;

import com.studs.demo.domain.content.UsuarioContent;
import com.studs.demo.domain.model.Usuario;
import com.studs.demo.domain.model.request.UsuarioRequest;
import com.studs.demo.domain.model.response.UsuarioResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("usuario")
public class UsuarioController {

    private final UsuarioContent content;

    public UsuarioController(UsuarioContent content) {
        this.content = content;
    }

    @PostMapping("cadastrar")
    public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuarioCreat = content.creteUsuarioContent(usuarioRequest);
        return new ResponseEntity<>(usuarioCreat, HttpStatus.CREATED);
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<UsuarioResponse> getUsuarioById(@RequestBody Long id) {
        UsuarioResponse usuario = content.getUsuarioIdContent(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("buscar/{email}")
    public ResponseEntity<UsuarioResponse> getUsuarioByEmail(@RequestBody String email) {
        UsuarioResponse usuario = content.getUsuarioByEmailContent(email);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping("atualizar")
    public ResponseEntity<UsuarioResponse> updateUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        UsuarioResponse usuario = content.updateUsuarioContent(usuarioRequest);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("deletar/{id}")
    public ResponseEntity<Void> deleteUsuario(@RequestBody Long id) {
        content.deleteUsuarioContent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}