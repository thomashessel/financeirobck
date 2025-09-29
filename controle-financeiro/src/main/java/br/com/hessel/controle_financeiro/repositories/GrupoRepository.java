package br.com.hessel.controle_financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hessel.controle_financeiro.model.entities.GrupoEntity;

@Repository
public interface GrupoRepository extends JpaRepository<GrupoEntity,Integer>  {

}
