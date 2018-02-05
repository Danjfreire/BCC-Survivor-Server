package com.example.bccsurvivor.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.bccsurvivor.model.QuestaoBanco;

public interface RepositorioBancoQuestoes extends CrudRepository<QuestaoBanco, Integer>{
	
	public List<QuestaoBanco> findByDisciplinaQuestaoOrderByIdQuestaoDesc(String disciplinaQuestao);
	
	public List<QuestaoBanco> findByIdQuestao(Integer idQuestao);
}
