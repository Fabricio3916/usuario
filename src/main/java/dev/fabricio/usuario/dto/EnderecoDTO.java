package dev.fabricio.usuario.dto;

import lombok.Builder;

@Builder
public record EnderecoDTO(

        String rua,
        String numero,
        String complemento,
        String cidade,
        String estado,
        String cep

) {
}
