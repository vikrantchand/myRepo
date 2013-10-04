package training.impetus.tp.commons.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import training.impetus.tp.commons.doamin.BaseEntity;
import training.impetus.tp.controller.AppController;

/**
 * Provides generic common implementation of GenericDao interface persistence
 * methods. Extend this abstract class to implement DAO for your specific needs.
 * 
 * @author Vikrant chand
 */
@Component
public abstract class GenericJpaDao<T, ID extends Serializable> implements
		GenericDao<T, ID> {

	private static final Logger logger = Logger.getLogger(GenericJpaDao.class);
	
	private Class<T> persistentClass;

	private EntityManager entityManager;

	public GenericJpaDao(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	protected EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Transactional(readOnly = true)
	public T findById(ID id) {
		T entity = (T) getEntityManager().find(getPersistentClass(), id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return getEntityManager().createQuery(
				"select x from " + getPersistentClass().getSimpleName() + " x")
				.getResultList();
	}
	
	@Transactional
	public T save(T entity) {
		logger.debug("GenericJpaDao: Testing " + entity.getClass());
		
		getEntityManager().persist(entity);
		
		logger.debug("GenericJpaDao: Completed:  " + entity.getClass());
		return entity;
	}

	@Transactional
	public T update(T entity) {
		T mergedEntity = getEntityManager().merge(entity);
		entityManager.flush();
		return mergedEntity;
	}

	public void delete(T entity) {
		if (BaseEntity.class.isAssignableFrom(persistentClass)) {
			getEntityManager().remove(
					getEntityManager().getReference(entity.getClass(),
							((BaseEntity) entity).getId()));
		} else {
			entity = getEntityManager().merge(entity);
			getEntityManager().remove(entity);
		}
	}

	public void flush() {
		getEntityManager().flush();
	}

}
