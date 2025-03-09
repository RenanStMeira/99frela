package com.studs.demo.domain.service;

import com.studs.demo.domain.model.Usuario;
import com.studs.demo.domain.repository.UsuarioRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;

@Service
@Validated
public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario createUsuario(@Valid @NotNull Usuario usuario) {
        validateEmailUniqueness(usuario.email());
        return repository.save(usuario);
    }

    public Usuario getUsuarioById(@NotNull Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public Usuario getUsuarioByEmail(@Email @NotNull String email) {
        return repository.findByEmail(email).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public Usuario updateUsuario(@Valid @NotNull Usuario usuario) {
        validateEmailUniqueness(usuario.email());
        return repository.save(usuario);
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