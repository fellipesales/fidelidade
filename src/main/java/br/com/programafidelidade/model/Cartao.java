package br.com.programafidelidade.model;

public class Cartao {
	
	private int id;
	private Long Numero;
	private Cliente cliente;
	private Empresa empresa;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getNumero() {
		return Numero;
	}
	public void setNumero(Long numero) {
		Numero = numero;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	

}
