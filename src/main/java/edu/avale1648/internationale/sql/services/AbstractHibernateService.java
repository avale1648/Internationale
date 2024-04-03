package edu.avale1648.internationale.sql.services;

import java.util.List;
import java.util.UUID;

import edu.avale1648.internationale.sql.dao.HibernateDao;

public abstract class AbstractHibernateService <T> {
	private HibernateDao<T> dao;
	
	public AbstractHibernateService( HibernateDao<T> dao) {
		this.dao = dao;
	}
	
	public T getById(UUID id) {
		return dao.getById(id);
	}
	
	public List<T> getAll() {
		return dao.getAll();
	}
	
	public T create(T entity) {
		return dao.create(entity);
	}
	
	public T update (T entity) {
		return dao.update(entity);
	}
	
	public void remove(final T entity) {
		dao.remove(entity);
	}
	
	public void remove(final UUID id) {
		dao.remove(id);
	}
}
