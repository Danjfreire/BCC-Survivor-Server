package com.example.bccsurvivor.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.bccsurvivor.model.QuestaoBanco;

public interface RepositorioBancoQuestoes extends CrudRepository<QuestaoBanco, Long>{
	
	public List<QuestaoBanco> findByDisciplinaQuestao(String disciplinaQuestao);
}