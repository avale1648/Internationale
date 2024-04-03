package edu.avale1648.internationale.sql.dao;

import java.util.List;
import java.util.UUID;

public interface HibernateDao<T> {
	public T getById(final UUID id);
	
	public List<T> getAll();
	
	public T create(final T entity);
	
	public T update(final T entity);
	
	public void remove(final T entity);
	
	public void remove(final UUID id);
}
