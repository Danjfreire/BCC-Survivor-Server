package com.example.bccsurvivor.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bccsurvivor.data.RespositorioQuestao;
import com.example.bccsurvivor.model.QuestaoJogo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
		
		QuestaoJogo q3 = new QuestaoJogo();
		q3.setTexto("Qual não é um tipo de memoria?");
		q3.setDisciplina("Introdução");
		q3.setAlternativa1("SSD");
		q3.setAlternativa2("RAM");
		q3.setAlternativa3("PENDRIVE");
		q3.setResposta("COOLER");
		repo.save(q3);
		
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

	@Autowired
	private void load() {
		try {
			File file = new File("questoes-jogo.json");
			InputStream targetStream = new FileInputStream(file);
			Reader reader = new InputStreamReader(targetStream);
			Gson gson = new GsonBuilder().create();
			List<QuestaoJogo> questoes = Arrays.asList(gson.fromJson(reader, QuestaoJogo[].class));
			repo.save(questoes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
