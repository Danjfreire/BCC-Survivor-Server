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
