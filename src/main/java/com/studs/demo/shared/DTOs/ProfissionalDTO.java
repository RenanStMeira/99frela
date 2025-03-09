package com.studs.demo.shared.DTOs;

import java.time.LocalDateTime;
import java.util.List;

public record ProfissionalDTO (
        String nome,
        String email,
        String senha,
        String telefone,
        String endereco,
        String tipoServico,
        List<LocalDateTime> disponibilidade
) {}
