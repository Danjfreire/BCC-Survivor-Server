package com.example.bccsurvivor.controllers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		int i = gerarId();
		System.out.println(i);
		questaoBanco.setIdQuestao(i);
		
		repositorio.save(questaoBanco);
		return "salvo";
	}
	
	@GetMapping("/id/{id}")
	public @ResponseBody Iterable<QuestaoBanco> buscarId(@PathVariable("id") Integer idQuestao) {
		return repositorio.findByIdQuestao(idQuestao);
	}
	
	@GetMapping("/disciplina_questao/{disciplina}")
	public @ResponseBody Iterable<QuestaoBanco> buscarQuestoes(@PathVariable("disciplina") String disciplinaQuestao) throws UnsupportedEncodingException {
		return repositorio.findByDisciplinaQuestaoOrderByIdQuestaoDesc(URLDecoder.decode(disciplinaQuestao,"UTF-8"));
	}
	
	@DeleteMapping(value="/remover")
	public @ResponseBody Iterable<QuestaoBanco> removerQuestao(@RequestParam Integer idQuestao,@RequestParam String disciplinaQuestao) throws UnsupportedEncodingException {
		repositorio.delete(idQuestao);
		return repositorio.findByDisciplinaQuestaoOrderByIdQuestaoDesc(URLDecoder.decode(disciplinaQuestao, "UTF-8"));
	}
	
	@PutMapping(value = "/atualizar/{id}", produces = "application/jason")
	public @ResponseBody String AtualizarUsuario(@PathVariable Integer id,@RequestBody QuestaoBanco questaoBanco) {
		repositorio.delete(id);
		questaoBanco.setIdQuestao(id);
		repositorio.save(questaoBanco);		
		return "atualizado";
	}
	
	private int gerarId() {
		List<QuestaoBanco> lista =(List<QuestaoBanco>) repositorio.findAll();
		int maior = 1;
		int i = 0;
		while(i < lista.size()) {
			if(lista.get(i).getIdQuestao() > maior)
				maior = lista.get(i).getIdQuestao();
			i++;
		}
		return ++maior;
	}
}
