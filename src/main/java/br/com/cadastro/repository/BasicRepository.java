package br.com.cadastro.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;



public abstract class BasicRepository<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private  Class<T> classe;

	@PersistenceContext
	private EntityManager manager;

	public BasicRepository(Class<T> classe) {

		this.classe = classe;

	}
	
	protected Session getSession(){
		
		Session session = manager.unwrap(Session.class);
		return session;
	}
	
	protected Criteria createCriteria(){
		
		Criteria criteria = getSession().createCriteria(classe);
		return criteria;
			
	}
	
	@SuppressWarnings("unchecked")
	protected List<T>listEntity(){
		List<T>lista = new ArrayList<T>();
		Criteria criteria = createCriteria();
		lista = criteria.list();
		return lista;
		
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
