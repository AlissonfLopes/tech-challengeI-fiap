package br.com.fiap.tech_challenge.repository;

import br.com.fiap.tech_challenge.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
