package com.example.bccsurvivor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bccsurvivor.data.RepositorioAdm;
import com.example.bccsurvivor.model.Adm;

@RestController
@RequestMapping("/adm")
public class ControlAdm {
	
	@Autowired
	private RepositorioAdm adm;
	
	@GetMapping("")
	public @ResponseBody Iterable<Adm> buscar(@RequestParam String admLogin,@RequestParam String admSenha) {
		return adm.findByAdmLoginAndAdmSenha(admLogin, admSenha);
	}
	
}
