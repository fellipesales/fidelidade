package br.com.programafidelidade.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.programafidelidade.model.Empresa;
import br.com.programafidelidade.repository.Empresas;

@Named
@javax.faces.view.ViewScoped
public class RegistroEmpresasBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Empresas empresas;
	
	private Empresa empresa;

	public void novo(){
		empresa = new Empresa();
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	
	public void adicionar(){
		
		empresas.Guardar(empresa);
	}

}
