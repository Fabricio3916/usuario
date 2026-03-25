package dev.fabricio.usuario.mapper;

import dev.fabricio.usuario.dto.EnderecoDTO;
import dev.fabricio.usuario.dto.TelefoneDTO;
import dev.fabricio.usuario.dto.UsuarioDTO;
import dev.fabricio.usuario.entity.Endereco;
import dev.fabricio.usuario.entity.Telefone;
import dev.fabricio.usuario.entity.Usuario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsuarioMapper {

    public Usuario toUsuario(UsuarioDTO dto) {

        List<Endereco> enderecos = dto.enderecos().stream().map(this::toEndereco).toList();
        List<Telefone> telefones = dto.telefones().stream().map(this::toTelefone).toList();

        return Usuario.builder()
                .nome(dto.nome())
                .email(dto.email())
                .senha(dto.senha())
                .enderecos(enderecos)
                .telefones(telefones)
                .build();
    }

    public UsuarioDTO toUsuarioDTO(Usuario usuario) {

       List<EnderecoDTO> enderecosDTOS = usuario.getEnderecos().stream().map(this::toEnderecoDTO).toList();
       List<TelefoneDTO> telefoneDTOS = usuario.getTelefones().stream().map(this::toTelefoneDTO).toList();

        return UsuarioDTO.builder()
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .senha(usuario.getSenha())
                .enderecos(enderecosDTOS)
                .telefones(telefoneDTOS)
                .build();
    }

    public TelefoneDTO toTelefoneDTO(Telefone telefone) {
        return TelefoneDTO.builder()
                .numero(telefone.getNumero())
                .ddd(telefone.getDdd())
                .build();
    }

    public Telefone toTelefone(TelefoneDTO dto) {
        return Telefone.builder()
                .numero(dto.numero())
                .ddd(dto.ddd())
                .build();
    }

    public EnderecoDTO toEnderecoDTO(Endereco endereco) {
        return EnderecoDTO.builder()
                .rua(endereco.getRua())
                .cidade(endereco.getCidade())
                .estado(endereco.getEstado())
                .numero(endereco.getNumero())
                .complemento(endereco.getComplemento())
                .cep(endereco.getCep())
                .build();
    }

    public Endereco toEndereco(EnderecoDTO dto) {
        return Endereco.builder()
                .rua(dto.rua())
                .numero(dto.numero())
                .complemento(dto.complemento())
                .cidade(dto.cidade())
                .estado(dto.estado())
                .cep(dto.cep())
                .build();
    }

}
