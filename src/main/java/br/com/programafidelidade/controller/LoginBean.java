package br.com.programafidelidade.controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.programafidelidade.model.Empresa;
import br.com.programafidelidade.repository.Empresas;

@Named
@ViewScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean logado;
	
	private String login;
	
	private String senha;

	@Inject
	private Empresas empresas;

	private Empresa empresa;
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Empresa getEmpresa() {
		return empresa;
	}



	public boolean isLogado() {
		return logado;
	}
}
