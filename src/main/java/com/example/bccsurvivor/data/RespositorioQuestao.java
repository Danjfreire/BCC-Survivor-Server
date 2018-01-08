package com.example.bccsurvivor.data;

import org.springframework.data.repository.CrudRepository;

import com.example.bccsurvivor.model.QuestaoJogo;

public interface RespositorioQuestao extends CrudRepository<QuestaoJogo, Long>{

    public Iterable<QuestaoJogo> findQuestaoJogoByDisciplina(String disciplina);

}
