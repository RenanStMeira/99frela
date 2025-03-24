package com.studs.demo.domain.service;

import com.studs.demo.domain.model.Usuario;
import com.studs.demo.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@Validated
public class UsuarioService {
    private final UsuarioRepository repository;
    Logger logger = Logger.getLogger(UsuarioService.class.getName());

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario createUsuario(@Valid @NotNull Usuario usuario) {
        validateEmailUniqueness(usuario.getEmail());
        return repository.save(usuario);
    }

    public Usuario getUsuarioById(@NotNull Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public Usuario getUsuarioByEmail(@Email @NotNull String email) {
        return repository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public Usuario updateUsuario(@Valid @NotNull Usuario usuario) {
        validateEmailUniqueness(usuario.getEmail());
        return repository.save(usuario);
    }

    public List<Usuario> getAllUsuarios() {
        return repository.findAll();
    }

    public void deleteUsuario(@NotNull Long id) {
        repository.deleteById(id);
    }

    private void validateEmailUniqueness(String email) {
        Optional<Usuario> existingUser = repository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new IllegalArgumentException("Email already in use");
        }
    }
}