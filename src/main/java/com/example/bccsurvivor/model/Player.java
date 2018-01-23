package com.example.bccsurvivor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nickname;
	private Integer faseAtual;
	private Integer numVidas;
	private Integer pulos;
	private Integer score;
	private Integer scoreRecorde;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getScoreRecorde() {
		return scoreRecorde;
	}

	public void setScoreRecorde(Integer scoreRecorde) {
		this.scoreRecorde = scoreRecorde;
	}

	public Integer getFaseAtual() {
		return faseAtual;
	}

	public void setFaseAtual(Integer faseAtual) {
		this.faseAtual = faseAtual;
	}

	public Integer getNumVidas() {
		return numVidas;
	}

	public void setNumVidas(Integer numVidas) {
		this.numVidas = numVidas;
	}

	public Integer getPulos() {
		return pulos;
	}

	public void setPulos(Integer pulos) {
		this.pulos = pulos;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
