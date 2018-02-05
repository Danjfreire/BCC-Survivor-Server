package com.example.bccsurvivor.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Adm {
	@Id
	@GeneratedValue
	private Long admId;
	private String admLogin;
	private String admSenha;
	private String admNome;
	public Long getAdmId() {
		return admId;
	}
	public void setAdmId(Long admId) {
		this.admId = admId;
	}
	public String getAdmLogin() {
		return admLogin;
	}
	public void setAdmLogin(String admLogin) {
		this.admLogin = admLogin;
	}
	public String getAdmSenha() {
		return admSenha;
	}
	public void setAdmSenha(String admSenha) {
		this.admSenha = admSenha;
	}
	public String getAdmNome() {
		return admNome;
	}
	public void setAdmNome(String admNome) {
		this.admNome = admNome;
	}

}
