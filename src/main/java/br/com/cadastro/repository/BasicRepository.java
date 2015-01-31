package br.com.cadastro.repository;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public abstract class BasicRepository<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private  Class<T> classe;

	@PersistenceContext
	private EntityManager manager;

	public BasicRepository(Class<T> classe) {

		this.classe = classe;

	}

	

	protected void addEntity(T entity) {

		manager.persist(entity);

	}

	protected T entity(long id) {

		return manager.find(classe, id);

	}


	protected void updateEntity(T entity) {

		manager.merge(entity);

	}

	protected void remove(long id) {

		T entity = manager.find(classe, id);
		manager.remove(entity);

	}

}
