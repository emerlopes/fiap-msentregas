package br.com.fiapmsentrega.infrastructure.database.repository;

import br.com.fiapmsentrega.infrastructure.database.entity.EntregaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<EntregaEntity, Long> {
}
