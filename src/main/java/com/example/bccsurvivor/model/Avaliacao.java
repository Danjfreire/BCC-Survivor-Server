package com.example.bccsurvivor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Avaliacao { 
	
	@Id
	@GeneratedValue
	private Integer idAvaliacao;
	private Integer idQuestao;
	private Integer idUsuario;
	private Integer tipoAvaliacao;
	private Integer valorAvaliacao;
	public Integer getIdAvaliacao() {
		return idAvaliacao;
	}
	public void setIdAvaliacao(Integer idAvalicao) {
		this.idAvaliacao = idAvalicao;
	}
	public Integer getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(Integer idQuestao) {
		this.idQuestao = idQuestao;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getTipoAvaliacao() {
		return tipoAvaliacao;
	}
	public void setTipoAvaliacao(Integer tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}
	public Integer getValorAvaliacao() {
		return valorAvaliacao;
	}
	public void setValorAvaliacao(Integer valorAvaliacao) {
		this.valorAvaliacao = valorAvaliacao;
	}
}
