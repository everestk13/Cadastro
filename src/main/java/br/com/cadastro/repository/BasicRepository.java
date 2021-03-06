package br.com.cadastro.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;

public abstract class BasicRepository<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private final Class<T> classe;

	@PersistenceContext
	public EntityManager manager;

	public BasicRepository(Class<T> classe) {

		this.classe = classe;

	}

	protected Session getSession() {

		Session session = manager.unwrap(Session.class);
		return session;
	}

	protected Criteria createCriteria() {

		Criteria criteria = getSession().createCriteria(classe);
		return criteria;

	}

	@SuppressWarnings({ "unchecked" })
	protected List<T> listEntity() {
		Criteria criteria = createCriteria();
		criteria.setFetchMode("endereco", FetchMode.JOIN);
		// criteria.setResultTransformer(criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();

	}

	protected void addEntity(T entity) {

		manager.persist(entity);

	}

	protected T entity(int id) {

		return manager.find(classe, id);

	}

	protected void updateEntity(T entity) {

		manager.merge(entity);

	}

	protected void remove(int id) {

		T entityFind = entity(id);
		manager.remove(entityFind);

	}

}
