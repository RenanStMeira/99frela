package com.studs.demo.application.controller;

import com.studs.demo.domain.content.UsuarioContent;
import com.studs.demo.domain.model.Usuario;
import com.studs.demo.domain.model.request.UsuarioRequest;
import com.studs.demo.domain.model.response.UsuarioResponse;
import jakarta.validation.Valid;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioContent content;

    public UsuarioController(UsuarioContent content) {
        this.content = content;
    }

    @PostMapping("cadastrar")
    public ResponseEntity<?> createUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest) {
        try {
            Usuario usuarioCreat = content.creteUsuarioContent(usuarioRequest);
            return new ResponseEntity<>(usuarioCreat, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro de integridade: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar usuário: " + e.getMessage());
        }
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<UsuarioResponse> getUsuarioById(@PathVariable Long id) {
        UsuarioResponse usuario = content.getUsuarioIdContent(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @GetMapping("buscar/email/{email}")
    public ResponseEntity<UsuarioResponse> getUsuarioByEmail(@PathVariable String email) {
        UsuarioResponse usuario = content.getUsuarioByEmailContent(email);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping("atualizar")
    public ResponseEntity<UsuarioResponse> updateUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        UsuarioResponse usuario = content.updateUsuarioContent(usuarioRequest);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        content.deleteUsuarioContent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}