package br.com.programafidelidade.repository;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.programafidelidade.model.Cliente;
import br.com.programafidelidade.model.Empresa;

public class Clientes implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public Empresa getEmpresa(String login, String senha){
		try {
            Empresa empresa = (Empresa) manager.createQuery("SELECT u from Usuario u where u.nomeUsuario = :name and u.senha = :senha")
                    .setParameter("name", login)
                    .setParameter("senha", senha).getSingleResult();

         return empresa;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}

	public Cliente Guardar(Cliente cliente) {
		manager.getTransaction().begin();
		cliente = manager.merge(cliente);
		manager.getTransaction().commit();
		return cliente;
	}

	public List<Cliente> todos() {
		return manager.createQuery("from Cliente order by id desc", Cliente.class).getResultList();
	}

	public Cliente porId(Long id) {
		return manager.find(Cliente.class, id);
	}
	
	public void Excluir(Cliente cliente){
		manager.getTransaction().begin();
		cliente = manager.find(Cliente.class,cliente.getId());
		manager.remove(cliente);
		manager.getTransaction().commit();
	}
	
	
	
}
