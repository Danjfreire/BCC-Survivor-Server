package com.example.bccsurvivor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bccsurvivor.data.RespositorioQuestao;
import com.example.bccsurvivor.model.QuestaoJogo;

@Controller
@RequestMapping(path="/bccsurvivor")
public class ControlQuestao {

	@Autowired
	private RespositorioQuestao repo;
	
	@GetMapping(path = "/add")
	public @ResponseBody String addQuestao() {
		
		QuestaoJogo q = new QuestaoJogo();
		q.setTexto("Qual sua linguagem de programação favorita?");
		q.setDisciplina("Introdução");
		q.setAlternativa1("C");
		q.setAlternativa2("Python");
		q.setAlternativa3("C#");
		q.setResposta("Java");
		repo.save(q);
		
		QuestaoJogo q2 = new QuestaoJogo();
		q2.setTexto("Quais desses tipos primitivos não existem em C");
		q2.setAlternativa1("int");
		q2.setAlternativa2("char");
		q2.setAlternativa3("double");
		q2.setResposta("string");
		q2.setDisciplina("Programacao I");
		repo.save(q2);
		
		return "Saved";
	}
	
	@GetMapping(path = "/questoes")
	public @ResponseBody Iterable<QuestaoJogo> questoes(){
		return repo.findAll();
	}

	@GetMapping(path = "/disciplina")
	public @ResponseBody Iterable<QuestaoJogo> disciplinas(@RequestParam String disciplina){
		return repo.findQuestaoJogoByDisciplina(disciplina);
	}

}
