package com.studs.demo.repository;

import com.studs.demo.domain.model.Usuario;
import com.studs.demo.domain.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void testFindByEmail() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setEmail("test@example.com");
        usuarioRepository.save(usuario);

        // Act
        Optional<Usuario> foundUsuario = usuarioRepository.findByEmail("test@example.com");

        // Assert
        assertThat(foundUsuario).isPresent();
        assertThat(foundUsuario.get().getEmail()).isEqualTo("test@example.com");
    }
}