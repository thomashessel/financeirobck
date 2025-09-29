package br.com.hessel.controle_financeiro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hessel.controle_financeiro.entities.GrupoEntity;
import br.com.hessel.controle_financeiro.repositories.GrupoRepository;
import jakarta.transaction.Transactional;

@Service
public class CrudGrupoService {
	
	@Autowired
	private GrupoRepository grupoRepository;

	
	public List<GrupoEntity> listaGrupos(){
		
		return grupoRepository.findAll();
	}
	public GrupoEntity listaGrupoPorId(Integer id){
		return grupoRepository.findById(id).orElse(null);
		
	}
	@Transactional
	public void salvaGrupo(GrupoEntity grupo) {
		grupoRepository.save(grupo);
	}
	@Transactional
	public void alteraGrupo(GrupoEntity grupo, Integer idGrupo) {
		GrupoEntity result=this.listaGrupoPorId(idGrupo);
		if(result!=null) {
			result.setNome(grupo.getNome());
			result.setTpoLancamento(grupo.getTpoLancamento());
			grupoRepository.save(result);
		}
	}
	@Transactional
	public void excluiGrupo(Integer idGrupo) {
		GrupoEntity result=this.listaGrupoPorId(idGrupo);
		if(result!=null) {
			grupoRepository.delete(result);
		}
	}
}
