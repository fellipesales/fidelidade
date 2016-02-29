package br.com.programafidelidade.controller;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

import br.com.programafidelidade.model.Cliente;
import br.com.programafidelidade.model.Empresa;
import br.com.programafidelidade.repository.Clientes;
import br.com.programafidelidade.repository.Empresas;


@Named
@ViewScoped
public class ClienteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Clientes clientes;
	
	private Cliente cliente;

	private List<Cliente> todosClientes;


	public void consultar() {
		todosClientes = clientes.todos();
		teste();
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
		//RequestContext.getCurrentInstance().execute("PF('novoClienteDialog').hide()");
		RequestContext.getCurrentInstance().update("frm:msgs-geral");
	}
	
	
	
	public void excluir(Cliente empresa){
		System.out.println(empresa);
		clientes.Excluir(empresa);
	}

	public List<Cliente> getTodosClientes() {
		return todosClientes;
	}
	
    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Empresa Alterada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição Cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void teste(){
    	System.out.println();
    }


}
