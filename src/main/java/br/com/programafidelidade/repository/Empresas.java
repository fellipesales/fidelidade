package br.com.programafidelidade.repository;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.programafidelidade.model.Empresa;

public class Empresas implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public Empresa getEmpresa(String login, String senha){
		try {
            Empresa empresa = (Empresa) manager.createQuery("SELECT u from Empresa u where u.login = :login and u.senha = :senha")
                    .setParameter("login", login)
                    .setParameter("senha", senha).getSingleResult();

         return empresa;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}

	public Empresa Guardar(Empresa empresa) {
		manager.getTransaction().begin();
		empresa = manager.merge(empresa);
		manager.getTransaction().commit();
		return empresa;
	}

	public List<Empresa> todas() {
		return manager.createQuery("from Empresa  order by id desc", Empresa.class).getResultList();
	}

	public Empresa porId(Long id) {
		return manager.find(Empresa.class, id);
	}
	
	public void Excluir(Empresa empresa){
		manager.getTransaction().begin();
		empresa = manager.find(Empresa.class,empresa.getId());
		manager.remove(empresa);
		manager.getTransaction().commit();
	}
	
	
	
}
