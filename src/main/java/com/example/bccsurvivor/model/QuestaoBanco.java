package com.example.bccsurvivor.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class QuestaoBanco {
	
	@Id
	@GeneratedValue
	private Integer idQuestao;
	private String perguntaQuestao;
	private String respostaQuestao;
	private String disciplinaQuestao;
	private String assuntoQuestao;
	private Date dataQuestao;
	private Integer autorQuestao;
	public Integer getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(Integer idQuestao) {
		this.idQuestao = idQuestao;
	}
	public String getPerguntaQuestao() {
		return perguntaQuestao;
	}
	public void setPerguntaQuestao(String perguntaQuestao) {
		this.perguntaQuestao = perguntaQuestao;
	}
	public String getRespostaQuestao() {
		return respostaQuestao;
	}
	public void setRespostaQuestao(String respostaQuestao) {
		this.respostaQuestao = respostaQuestao;
	}
	public String getDisciplinaQuestao() {
		return disciplinaQuestao;
	}
	public void setDisciplinaQuestao(String disciplinaQuestao) {
		this.disciplinaQuestao = disciplinaQuestao;
	}
	public String getAssuntoQuestao() {
		return assuntoQuestao;
	}
	public void setAssuntoQuestao(String assuntoQuestao) {
		this.assuntoQuestao = assuntoQuestao;
	}
	public Date getDataQuestao() {
		return dataQuestao;
	}
	public void setDataQuestao(Date dataQuestao) {
		this.dataQuestao = dataQuestao;
	}
	public void setAutorQuestao(Integer autorQuestao) {
		this.autorQuestao = autorQuestao;
	}
}
