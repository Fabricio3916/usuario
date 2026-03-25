package dev.fabricio.usuario.repository;

import dev.fabricio.usuario.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
