package com.example.bccsurvivor.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.bccsurvivor.model.Adm;

public interface RepositorioAdm extends CrudRepository<Adm, Long>{
	
	public List<Adm> findByAdmLoginAndAdmSenha(String admLogin, String admSenha);
}
