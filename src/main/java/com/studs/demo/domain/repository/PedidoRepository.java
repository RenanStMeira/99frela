package com.studs.demo.domain.repository;

import com.studs.demo.domain.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByIdUsuarioAndEnderecoOrigemAndDataHora(Long idUsuario, String enderecoOrigem, LocalDateTime dataHora);
}
