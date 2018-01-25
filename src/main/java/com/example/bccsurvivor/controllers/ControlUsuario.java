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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bccsurvivor.data.RepositorioPlayer;
import com.example.bccsurvivor.data.RepositorioUser;
import com.example.bccsurvivor.model.LoginRequest;
import com.example.bccsurvivor.model.Player;
import com.example.bccsurvivor.model.QuestaoJogo;
import com.example.bccsurvivor.model.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping(path = "/user")
public class ControlUsuario {

	@Autowired
	private RepositorioUser repoUser;
	@Autowired
	private RepositorioPlayer repoPlayer;

	@GetMapping(path = "/login")
	public @ResponseBody Player efetuarLogin(@RequestParam String login, String senha) {

		System.out.println(login);
		System.out.println(senha);

		Usuario u = repoUser.findUsuarioByLoginAndSenha(login,senha);
		if (u != null) {
			Player p = repoPlayer.findPlayerById(u.getId());
			return p;
		}

		return null;
	}

	@GetMapping("/cadastro")
	public @ResponseBody String cadastrarUsuario(@RequestParam String login, String senha, String email,
			String nickname) {
		try {
		Usuario u = new  Usuario();
		u.setEmail(email);
		u.setLogin(login);
		u.setSenha(senha);
		
		repoUser.save(u);
		
		Player p = new Player();
		p.setFaseAtual(1);
		p.setNickname(nickname);
		p.setNumVidas(3);
		p.setPulos(1);
		p.setScore(0);
		p.setScoreRecorde(0);
		
		repoPlayer.save(p);

		} catch (Exception e) {
			return "Falha no cadastro";
		}

		return "Saved";
	}

	@RequestMapping("/savestate")
	public void saveState(InputStream input) {
		System.out.println("ENTROU NO SAVESTATE");
		Reader reader = new InputStreamReader(input);
		Gson gson = new GsonBuilder().create();
		Player player = gson.fromJson(reader, Player.class);
		
		Player playerSalvo = repoPlayer.findPlayerById(player.getId());
		playerSalvo.setFaseAtual(player.getFaseAtual());
		playerSalvo.setNumVidas(player.getNumVidas());
		playerSalvo.setPulos(player.getPulos());
		playerSalvo.setScore(player.getScore());
		playerSalvo.setScoreRecorde(player.getScoreRecorde());
		
		repoPlayer.save(playerSalvo);
	}
	
	@RequestMapping("/players")
	public @ResponseBody Iterable<Player> allPlayers(){
		return repoPlayer.findAll();
	}

}
