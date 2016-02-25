package br.com.programafidelidade.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cartao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Long Numero;
	private Long pontos;
	private Cliente cliente;
	private Empresa empresa;
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(nullable = false)
	public Long getNumero() {
		return Numero;
	}
	public void setNumero(Long numero) {
		Numero = numero;
	}
	
	@Column
	public Long getPontos() {
		return pontos;
	}
	public void setPontos(Long pontos) {
		this.pontos = pontos;
	}
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_cliente")
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_empresa")
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	

}
