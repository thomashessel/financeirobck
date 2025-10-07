package br.com.hessel.controle_financeiro.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.hessel.controle_financeiro.model.entities.GrupoEntity;
import br.com.hessel.controle_financeiro.model.exceptions.RecursoEmUsoException;
import br.com.hessel.controle_financeiro.model.exceptions.RecursoNaoEncontradoException;
import br.com.hessel.controle_financeiro.repositories.GrupoRepository;
import jakarta.transaction.Transactional;

@Service
public class CrudGrupoService {

	@Autowired
	private GrupoRepository grupoRepository;

	public List<GrupoEntity> listaGrupos() {

		return grupoRepository.findAll();
	}

	public GrupoEntity listaGrupoPorId(Integer id) {
		return grupoRepository.findById(id).orElseThrow(() -> new RecursoNaoEncontradoException(
				String.format("Não foi encontrado um grupo com código: %d", id)));

	}

	@Transactional
	public void salvaGrupo(GrupoEntity grupo) {
		grupoRepository.save(grupo);
	}

	@Transactional
	public void alteraGrupo(GrupoEntity grupo, Integer idGrupo) {
		GrupoEntity result = this.listaGrupoPorId(idGrupo);
		result.setNome(grupo.getNome());
		result.setTpoLancamento(grupo.getTpoLancamento());
		grupoRepository.save(result);

	}
	
	public void excluiGrupo(Integer idGrupo) {
		this.listaGrupoPorId(idGrupo);
		try {
			grupoRepository.deleteById(idGrupo);
		}
		catch(DataIntegrityViolationException e) {
			throw new RecursoEmUsoException(
					String.format("Não foi possível excluir o grupo: %d. Ela está em uso por outro recurso", idGrupo));
		}
				
	}
}
