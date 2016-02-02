package br.com.programafidelidade.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.programafidelidade.model.Empresa;
import br.com.programafidelidade.repository.Empresas;

@Named
@ViewScoped
public class EmpresaBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Empresas empresas;

	private Empresa empresa;

	private List<Empresa> todasEmpresas;


	public void consultar() {
		todasEmpresas = empresas.todas();
	}

	public void novo() {
		empresa = new Empresa();
		System.out.println("Novo");
		System.out.println(empresa);

	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void adicionar() {
		empresas.Guardar(empresa);
		consultar();
		FacesMessage msg = new FacesMessage("Empresa Cadastrada");
		FacesContext.getCurrentInstance().addMessage(null, msg);

		RequestContext.getCurrentInstance().execute("PF('novaEmpresaDialog').hide()");
		RequestContext.getCurrentInstance().update("frm:msgs-geral");
	}

	public List<Empresa> getTodasEmpresas() {
		return todasEmpresas;
	}

}