package br.com.hessel.controle_financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hessel.controle_financeiro.model.entities.HistoricoMetaEntity;

@Repository
public interface HistoricoMetaRepository extends JpaRepository<HistoricoMetaEntity, Integer> {

}
