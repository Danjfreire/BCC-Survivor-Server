package com.example.bccsurvivor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.bccsurvivor.data.RepositorioAvaliacao;
import com.example.bccsurvivor.model.Avaliacao;

@RestController
@RequestMapping("bccsurvivor/avaliacao")
public class ControlAvaliacao {
	
	@Autowired
	private RepositorioAvaliacao repositorio;
	
	@PostMapping(value = "/novo", produces = "application/jason")
	public @ResponseBody String AdicionarAvaliacao(@RequestBody Avaliacao avaliacao) {
	
		repositorio.save(avaliacao);
		
		return "salvo";
	}
	
	@GetMapping("/avaliacaoid/{id_questao}")
	public @ResponseBody Iterable<Avaliacao> buscarId(@PathVariable("id_questao") Integer idQuestao) {
		return repositorio.findByIdQuestao(idQuestao);
	}
	
	@GetMapping("/avaliacao")
	public @ResponseBody Iterable<Avaliacao> buscarIdQUT(@RequestParam Integer idQuestao,@RequestParam Integer idUsuario, @RequestParam Integer tipoAvaliacao) {
		return repositorio.findByIdQuestaoAndIdUsuarioAndTipoAvaliacao(idQuestao, idUsuario, tipoAvaliacao);
	}
	
	@GetMapping("/quantidade")
	public @ResponseBody Iterable<Avaliacao> buscarQuantidade(@RequestParam Integer idQuestao,@RequestParam Integer tipoAvaliacao, @RequestParam Integer valorAvaliacao) {
		return repositorio.findByIdQuestaoAndTipoAvaliacaoAndValorAvaliacao(idQuestao, tipoAvaliacao, valorAvaliacao);
	}
}
