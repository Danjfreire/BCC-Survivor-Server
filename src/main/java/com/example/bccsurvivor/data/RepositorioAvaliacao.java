package com.example.bccsurvivor.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bccsurvivor.model.Avaliacao;

public interface RepositorioAvaliacao extends CrudRepository<Avaliacao, Long>  {
	
	public List<Avaliacao> findByIdQuestaoAndIdUsuarioAndTipoAvaliacao(Integer idQuestao, Integer idUsuario, Integer tipoAvaliacao);
	
	public List<Avaliacao> findByIdQuestao(Integer idQuestao);
}
