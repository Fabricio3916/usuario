package dev.fabricio.usuario.dto;

import lombok.Builder;

@Builder
public record TelefoneDTO(
        String numero,
        String ddd

) {}
