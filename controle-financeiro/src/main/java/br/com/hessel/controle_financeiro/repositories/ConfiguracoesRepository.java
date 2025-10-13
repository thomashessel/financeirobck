package br.com.hessel.controle_financeiro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hessel.controle_financeiro.model.entities.ConfiguracoesEntity;

@Repository
public interface ConfiguracoesRepository extends JpaRepository<ConfiguracoesEntity,Integer>  {

}
