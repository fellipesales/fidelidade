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
}
