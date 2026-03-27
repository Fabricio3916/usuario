package dev.fabricio.usuario.service;

import dev.fabricio.usuario.dto.UsuarioDTO;
import dev.fabricio.usuario.entity.Usuario;
import dev.fabricio.usuario.exceptions.EmailAlreadyExistsException;
import dev.fabricio.usuario.mapper.UsuarioMapper;
import dev.fabricio.usuario.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO) {
        emailExistente(usuarioDTO.email());
        Usuario usuario = usuarioMapper.toUsuario(usuarioDTO);
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.senha()));
        return usuarioMapper.toUsuarioDTO(usuarioRepository.save(usuario));
    }

    public void emailExistente(String email) {
        if (usuarioRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException("Email ja cadastrado: " + email);
        }
    }


}
