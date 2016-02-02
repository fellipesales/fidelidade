package br.com.programafidelidade.util;


import javax.persistence.Persistence;

import br.com.programafidelidade.model.Empresa;

public class CriarTabelas {

	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("FidelidadePU");
		
		Empresa empresa = new Empresa();
		empresa.setCnpj("88.128.331/0001-52");
		empresa.setContato("company@company.com");
		empresa.setLogin("teste");
		empresa.setNome("Velasco & Sales");
		empresa.setSenha("123");
		

		
	}

}
