package com.example.bccsurvivor.data;

import org.springframework.data.repository.CrudRepository;

import com.example.bccsurvivor.model.Player;
import com.example.bccsurvivor.model.QuestaoJogo;

public interface RepositorioPlayer extends CrudRepository<Player, Long>{

	public Player findPlayerById(Integer id);
}
