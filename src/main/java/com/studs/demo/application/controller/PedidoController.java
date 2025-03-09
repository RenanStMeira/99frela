package com.studs.demo.application.controller;

import com.studs.demo.domain.content.PedidoContent;
import com.studs.demo.domain.model.Pedido;
import com.studs.demo.domain.model.request.PedidoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    private final PedidoContent content;

    public PedidoController(PedidoContent content) {
        this.content = content;
    }

    @PostMapping("cadastrar")
    public ResponseEntity<Pedido> createPedido(@RequestBody PedidoRequest pedidoRequest) {
        Pedido pedidoCreat = content.createPedidoContent(pedidoRequest);
        return new ResponseEntity<>(pedidoCreat, HttpStatus.CREATED);
    }

    @PostMapping("atualizar")
    public ResponseEntity<Pedido> updatePedido(@RequestBody PedidoRequest pedidoRequest) {
        Pedido pedido = content.updatePedidoContent(pedidoRequest);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @PostMapping("deletar")
    public ResponseEntity<Void> deletePedido(@RequestBody Long id) {
        content.deletePedidoContent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("buscar/{id}")
    public ResponseEntity<Pedido> getPedidoById(@RequestBody Long id) {
        Pedido pedido = content.getPedidoByIdContent(id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }
}
