package edu.avale1648.internationale.sql.dao;

import java.util.List;
import java.util.UUID;

import edu.avale1648.internationale.sql.util.HibernateSessionFactoryUtil;

public abstract class AbstractHibernateDao<T> implements HibernateDao<T>{
	private final Class<T> clazz;

	public AbstractHibernateDao(final Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public T getById(final UUID id) {
		return (T) HibernateSessionFactoryUtil.getSessionFactory().openSession().get(clazz, id);
	}

	@Override
	public List<T> getAll() {
		return (List<T>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("from " + clazz.getName(), clazz).list();
	}

	@Override
	public T create(final T entity) {
		var session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		var transaction = session.beginTransaction();
		session.persist(entity);
		transaction.commit();
		session.close();
		
		return entity;
	}

	@Override
	public T update(final T entity) {
		var session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		var transaction = session.beginTransaction();
		var result = (T) session.merge(entity);
		transaction.commit();
		session.close();
		
		return result;
	}

	@Override
	public void remove(final T entity) {
		var session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
		var transaction = session.beginTransaction();
		session.remove(entity);
		transaction.commit();
		session.close();
	}

	@Override
	public void remove(final UUID id) {
		final T entity = getById(id);

		remove(entity);
	}
}
