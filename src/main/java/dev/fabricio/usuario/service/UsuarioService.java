package dev.fabricio.usuario.service;

import dev.fabricio.usuario.dto.UsuarioDTO;
import dev.fabricio.usuario.entity.Usuario;
import dev.fabricio.usuario.mapper.UsuarioMapper;
import dev.fabricio.usuario.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
       Usuario usuario = usuarioMapper.toUsuario(usuarioDTO);
       return usuarioMapper.toUsuarioDTO(usuarioRepository.save(usuario));
    }

}
