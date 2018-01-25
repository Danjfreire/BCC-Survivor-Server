package com.example.bccsurvivor.controllers;

import java.net.URLDecoder;
import java.sql.Date;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bccsurvivor.data.RepositorioBancoQuestoes;
import com.example.bccsurvivor.model.QuestaoBanco;

@Controller
@RequestMapping(path = "bccsurvivor/banco")
public class ControlBancoQuestoes {
	
	@Autowired
	private RepositorioBancoQuestoes repositorio;
	
	@PostMapping(value = "/novo", produces = "application/jason")
	public @ResponseBody String AdicionarUsuario(@RequestBody QuestaoBanco questaoBanco) {
		repositorio.save(questaoBanco);
		return "salvo";
	}
	
	@GetMapping("/id/{id}")
	public @ResponseBody Iterable<QuestaoBanco> buscarId(@PathVariable("id") Integer idQuestao) {
		return repositorio.findByIdQuestao(idQuestao);
	}
	
	@GetMapping("/disciplina_questao")
	public @ResponseBody Iterable<QuestaoBanco> buscarQuestoes(@RequestParam String disciplinaQuestao) {
		
		return repositorio.findByDisciplinaQuestao(disciplinaQuestao);
	}
}
