package br.com.hessel.controle_financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hessel.controle_financeiro.model.entities.MovimentoEntity;

@Repository
public interface MovimentoRepository extends JpaRepository<MovimentoEntity, Integer>{

}
