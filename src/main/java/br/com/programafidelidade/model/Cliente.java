package br.com.programafidelidade.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	private int id;
	private String CPF;
	private String nome;
	private String contato;
	
	private List<Empresa> listaEmpresa = new ArrayList<Empresa>();
	private List<Cartao> listacartao = new ArrayList<Cartao>();

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
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
	public List<Empresa> getListaEmpresa() {
		return listaEmpresa;
	}
	public void setListaEmpresa(List<Empresa> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}
	public List<Cartao> getListacartao() {
		return listacartao;
	}
	public void setListacartao(List<Cartao> listacartao) {
		this.listacartao = listacartao;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", CPF=" + CPF + ", nome=" + nome + ", contato=" + contato + "]";
	}

	
}
