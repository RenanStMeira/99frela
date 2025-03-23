package com.studs.demo.service;

import com.studs.demo.domain.model.Usuario;
import com.studs.demo.domain.repository.UsuarioRepository;
import com.studs.demo.domain.service.UsuarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository repository;

    @InjectMocks
    private UsuarioService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateUsuario() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);
        usuario.setEmail("test@example.com");

        when(repository.save(usuario)).thenReturn(usuario);

        Usuario createdUsuario = service.createUsuario(usuario);

        assertNotNull(createdUsuario);
        assertEquals(1L, createdUsuario.getIdUsuario());
        verify(repository, times(1)).save(usuario);
    }

    @Test
    void testGetUsuarioById() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(usuario));

        Usuario foundUsuario = service.getUsuarioById(1L);

        assertNotNull(foundUsuario);
        assertEquals(1L, foundUsuario.getIdUsuario());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testGetUsuarioByEmail() {
        Usuario usuario = new Usuario();
        usuario.setEmail("test@example.com");

        when(repository.findByEmail("test@example.com")).thenReturn(Optional.of(usuario));

        Usuario foundUsuario = service.getUsuarioByEmail("test@example.com");

        assertNotNull(foundUsuario);
        assertEquals("test@example.com", foundUsuario.getEmail());
        verify(repository, times(1)).findByEmail("test@example.com");
    }

}