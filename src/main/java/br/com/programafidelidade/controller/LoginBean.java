package br.com.programafidelidade.controller;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.programafidelidade.model.Empresa;
import br.com.programafidelidade.repository.Empresas;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;

	private Empresa empresa = new Empresa();
	
	

	public String Logar() {
		System.out.println(empresa);
		empresa = empresas.getEmpresa(empresa.getLogin(), empresa.getSenha());

		
		
		if (empresa == null) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario não cadastrado", "Erro no Login");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			return null;
		}

		return "/home?faces-redirect=true";
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public String Logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/home?faces-redirect=true";
	}
}
