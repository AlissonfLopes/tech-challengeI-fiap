package br.com.fiap.tech_challenge.repository;

import br.com.fiap.tech_challenge.entities.Aparelho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AparelhoRepository extends JpaRepository<Aparelho, Long> {
}
