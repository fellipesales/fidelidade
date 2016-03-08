package br.com.programafidelidade.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;
import br.com.programafidelidade.model.Cliente;
import br.com.programafidelidade.model.Empresa;
import br.com.programafidelidade.repository.Clientes;
import br.com.programafidelidade.repository.Empresas;

@Named
@ViewAccessScoped
public class ClienteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Clientes clientes;
	
	@Inject
	private Empresas empresas;
	
	private boolean logado;
	private String login, senha;
	private Empresa empresa;
	private Cliente cliente;

	private List<Cliente> todosClientes;

	
	
	public void consultar() {

		System.out.println(empresa);
		todosClientes = clientes.todos();
	}

	public void novo() {
		cliente = new Cliente();

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void adicionar() {
		clientes.Guardar(cliente);
		consultar();
		FacesMessage msg = new FacesMessage("Cliente Cadastrado");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		RequestContext.getCurrentInstance().update("messagens-geral");
	}

	public void excluir(Cliente empresa) {
		System.out.println(empresa);
		clientes.Excluir(empresa);
	}

	public List<Cliente> getTodosClientes() {
		return todosClientes;
	}
	
	
	public String Logar() {
		System.out.println(login);
		System.out.println(senha);
		Empresa empresaBuscada = (Empresa) empresas.getEmpresa(login, senha);
		
		if (empresaBuscada == null) {
			login = null;
			senha = null;
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario não cadastrado", "Erro no Login");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			
			return "/login?faces-redirect=true";		
					
		} else {
			empresa = empresaBuscada;
			System.out.println(empresa);
			logado = true;
			return "/home?faces-redirect=true";
		}

	}

	public String Logout() {
		empresa = null;
		logado = false;
		login = null;
		senha = null;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";

	}

	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Empresa Alterada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edição Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public boolean isLogado() {
		return logado;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


}
