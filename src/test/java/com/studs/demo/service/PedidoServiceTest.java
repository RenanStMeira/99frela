package com.studs.demo.service;

import com.studs.demo.domain.model.Pedido;
import com.studs.demo.domain.repository.PedidoRepository;
import com.studs.demo.domain.service.PedidoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PedidoServiceTest {

    @Mock
    private PedidoRepository repository;

    @InjectMocks
    private PedidoService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePedido() {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(1L);

        when(repository.save(pedido)).thenReturn(pedido);

        Pedido createdPedido = service.createPedido(pedido);

        assertNotNull(createdPedido);
        assertEquals(1L, createdPedido.getIdPedido());
        verify(repository, times(1)).save(pedido);
    }

    @Test
    void testGetPedidoById() {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(pedido));

        Pedido foundPedido = service.getPedidoById(1L);

        assertNotNull(foundPedido);
        assertEquals(1L, foundPedido.getIdPedido());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void testUpdatePedido() {
        Pedido pedido = new Pedido();
        pedido.setIdPedido(1L);

        when(repository.existsById(1L)).thenReturn(true);
        when(repository.save(pedido)).thenReturn(pedido);

        Pedido updatedPedido = service.updatePedido(pedido);

        assertNotNull(updatedPedido);
        assertEquals(1L, updatedPedido.getIdPedido());
        verify(repository, times(1)).existsById(1L);
        verify(repository, times(1)).save(pedido);
    }

    @Test
    void testDeletePedido() {
        when(repository.existsById(1L)).thenReturn(true);

        service.deletePedido(1L);

        verify(repository, times(1)).existsById(1L);
        verify(repository, times(1)).deleteById(1L);
    }
}