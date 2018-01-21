package com.example.bccsurvivor.data;

import org.springframework.data.repository.CrudRepository;

import com.example.bccsurvivor.model.QuestaoJogo;
import com.example.bccsurvivor.model.Usuario;

public interface RepositorioUser extends CrudRepository<Usuario, Long>{

	public Usuario findUsuarioByLoginAndSenha(String login, String senha);
	public Usuario findUsuarioByLogin(String login);
}
