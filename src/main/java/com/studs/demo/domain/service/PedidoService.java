package com.studs.demo.domain.service;

import com.studs.demo.domain.model.Pedido;
import com.studs.demo.domain.repository.PedidoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class PedidoService {
    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public Pedido createPedido(@Valid @NotNull Pedido pedido) {
//        validatePedidoUniqueness(pedido);
        return repository.save(pedido);
    }

    public Pedido getPedidoById(@NotNull Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido not found"));
    }

    public Pedido updatePedido(@Valid @NotNull Pedido pedido) {
        validatePedidoExists(pedido.getIdPedido());
        return repository.save(pedido);
    }

    public void deletePedido(@NotNull Long id) {
        validatePedidoExists(id);
        repository.deleteById(id);
    }

    public List<Pedido> getAll() {
        return repository.findAll();
    }

    private void validatePedidoUniqueness(Pedido pedido) {
        // ✅ SÓ validar se o ID não for null (pedido existente)
        if (pedido.getIdPedido() != null) {
            Optional<Pedido> existing = repository.findById(pedido.getIdPedido());
            if (existing.isPresent()) {
                throw new IllegalArgumentException("Pedido já existe");
            }
        }

        // OU validar por outros campos únicos
        // Por exemplo: mesmo usuário, mesmo endereço, mesmo horário
        List<Pedido> duplicates = repository.findByIdUsuarioAndEnderecoOrigemAndDataHora(
                pedido.getIdUsuario(),
                pedido.getEnderecoOrigem(),
                pedido.getDataHora()
        );

        if (!duplicates.isEmpty()) {
            throw new IllegalArgumentException("Já existe um pedido similar");
        }
    }

    private void validatePedidoExists(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Pedido not found");
        }
    }

}