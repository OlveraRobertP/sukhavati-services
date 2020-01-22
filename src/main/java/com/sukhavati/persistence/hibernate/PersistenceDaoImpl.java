package com.sukhavati.persistence.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.criterion.Restrictions;

import com.sukhavati.dao.PersistenceDao;

/**
 * Clase base para todas las clases de persistencia; cualquier clase de acceso a
 * datos, debe de heredar esta clase.
 *
 * @author jolverap
 * @version 1.0
 * @param <E>
 * @param <E> El tipo de objeto que esta mapeado a la BD
 */
public class PersistenceDaoImpl<E> implements PersistenceDao<E> {

	private static SessionFactory sessionFactory;

	protected Class<E> persistentClass;

	private Session session;

	static {
		// A SessionFactory is set up once for an application!
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("config/hibernate.cfg.xml") // configures settings
																									// from
																									// hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble
			// building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

	{
		this.persistentClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public void openSession() {
		this.session = this.sessionFactory.openSession();
	}

	@Override
	public void closeSession() {
		this.session.close();
	}

	@Override
	public void saveOrUpdate(E value) {
		this.session.saveOrUpdate(persistentClass.getName(), value);
	}

	@Override
	public void delete(E value) {
		this.session.delete(persistentClass.getName(), value);
	}

	@Override
	public E findBy(String criteria, Object value) {
		return (E) this.session.createCriteria(persistentClass).add(Restrictions.eq(criteria, value)).uniqueResult();

	}

	@Override
	public E findById(Serializable id) {
		return (E) this.session.get(persistentClass, id);
	}

	@Override
	public List<E> findAll() {
		return this.session.createCriteria(persistentClass).list();
	}

}