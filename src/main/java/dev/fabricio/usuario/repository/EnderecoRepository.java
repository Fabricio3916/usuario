package dev.fabricio.usuario.repository;

import dev.fabricio.usuario.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
