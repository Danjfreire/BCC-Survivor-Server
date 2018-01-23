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
	private Integer gostouPergunta;
	private Integer gostouResposta;
	private Integer naoGostouPergunta;
	private Integer naoGostouResposta;
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
	public Integer getGostouPergunta() {
		return gostouPergunta;
	}
	public void setGostouPergunta(Integer gostouPergunta) {
		this.gostouPergunta = gostouPergunta;
	}
	public Integer getGostouResposta() {
		return gostouResposta;
	}
	public void setGostouResposta(Integer gostouResposta) {
		this.gostouResposta = gostouResposta;
	}
	public Integer getNaoGostouPergunta() {
		return naoGostouPergunta;
	}
	public void setNaoGostouPergunta(Integer naoGostouPergunta) {
		this.naoGostouPergunta = naoGostouPergunta;
	}
	public Integer getNaoGostouResposta() {
		return naoGostouResposta;
	}
	public void setNaoGostouResposta(Integer naoGostouResposta) {
		this.naoGostouResposta = naoGostouResposta;
	}
	public Integer getAutorQuestao() {
		return autorQuestao;
	}
	public void setAutorQuestao(Integer autorQuestao) {
		this.autorQuestao = autorQuestao;
	}
}
