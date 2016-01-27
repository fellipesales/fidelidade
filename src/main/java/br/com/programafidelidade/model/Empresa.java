package br.com.programafidelidade.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	
	private int id;
	private String CNPJ;
	private String nome;
	private String contato;
	private String login;
	private String senha;
	

	private List<Cartao> listaCartao = new ArrayList<Cartao>();
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public List<Cartao> getListaCartao() {
		return listaCartao;
	}
	public void setListaCartao(List<Cartao> listaCartao) {
		this.listaCartao = listaCartao;
	}
	public List<Cliente> getListaCliente() {
		return listaCliente;
	}
	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	
}
