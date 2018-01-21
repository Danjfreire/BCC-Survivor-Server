package com.example.bccsurvivor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bccsurvivor.data.RepositorioPlayer;
import com.example.bccsurvivor.data.RepositorioUser;
import com.example.bccsurvivor.model.LoginRequest;
import com.example.bccsurvivor.model.Player;
import com.example.bccsurvivor.model.Usuario;

@Controller
@RequestMapping(path="/user")
public class ControlUsuario {

	@Autowired
	private RepositorioUser repoUser;
	@Autowired
	private RepositorioPlayer repoPlayer;
	
	@GetMapping(path = "/login")
	public @ResponseBody Usuario efetuarLogin(@RequestParam String login, String senha){
		
		System.out.println(login);
		System.out.println(senha);
		
		Usuario u = repoUser.findUsuarioByLogin(login);
		if(u != null)
			return u;
		
		return null;
	}
	
	@GetMapping("/cadastro")
	public @ResponseBody String cadastrarUsuario(@RequestParam String login, String senha, String email) {
		try {
			Usuario u = new Usuario();
			u.setLogin(login);
			u.setSenha(senha);
			u.setEmail(email);
			
			//Player p = new Player();
				
			repoUser.save(u);
		}catch (Exception e) {
			return "Falha no cadastro";
		}
		
		return "Saved";
	}
	
}
