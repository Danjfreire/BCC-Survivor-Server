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
		q.setTexto("Qual sua linguagem de programa��o favorita?");
		q.setDisciplina("Programacao");
		q.setAlternativa1("C");
		q.setAlternativa2("Python");
		q.setAlternativa3("C#");
		q.setResposta("Java");
		repo.save(q);
		
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
