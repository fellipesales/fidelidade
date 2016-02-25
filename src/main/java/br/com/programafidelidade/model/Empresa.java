package br.com.programafidelidade.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class Empresa implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String nome;
	private String cnpj;
	private String contato;
	private String login;
	private String senha;


	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@CNPJ
	@NotEmpty
	@Column(length = 20, nullable = false )
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@NotEmpty
	@Column( length = 80, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty
	@Column( length = 50, nullable = false)
	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}


	@NotEmpty
	@Column( length = 32, nullable = false)
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@NotEmpty
	@Column( length = 40, nullable = false)
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {

		this.login = login;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", nome=" + nome + ", cnpj=" + cnpj + ", contato=" + contato + ", login=" + login
				+ ", senha=" + senha + "]";
	}


	

}
