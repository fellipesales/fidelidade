package br.com.programafidelidade.util;


import javax.persistence.Persistence;

import br.com.programafidelidade.model.Empresa;

public class CriarTabelas {

	public static void main(String[] args) {
		
		Persistence.createEntityManagerFactory("FidelidadePU");

		
	}

}
