package hu.modsstore.model.dao.impl;

import hu.modsstore.model.dao.GenericDAO;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * AbstractGenericDAOImpl extends HibernateDaoSupport class and implements
 * HibernateDAO interface. This class supports some basic operation with entity.
 *
 * @param <T>
 *                type of the entity
 * @param <I>
 *                type of the id of entity
 */
public abstract class AbstractGenericDAOImpl < T, I extends Serializable >
        extends HibernateDaoSupport implements GenericDAO < T, I > {

    /**
     * Every DAO implementation must implement this method.
     * @return return the type of entity (T)
     */
    protected abstract Class < T > getPersistentClass();

    /**
     * Deletes the given entity.
     * @param entityId the id of the entity to be deleted
     */
    public void deleteById(final I entityId) {
        getHibernateTemplate().delete(findById(entityId));
    }

    /**
     * Deletes the given entity.
     * @param entity the entity to be deleted
     */
    public void delete(final Object entity) {
        getHibernateTemplate().delete(entity);
    }

    /**
     * List all entities for this DAO.
     * @return a list of entities (can be empty list)
     */
    @SuppressWarnings("unchecked")
    public List < T > listAll() {
        return getHibernateTemplate().loadAll(this.getPersistentClass());
    }

    /**
     * Locates a persistent entity by it's id.
     * @param entitityId the id of the entity
     * @return the persistent object or null if not exists
     */
    @SuppressWarnings("unchecked")
    public T findById(final I entitityId) {
        return (T) getHibernateTemplate().get(this.getPersistentClass(),
                entitityId);
    }

    /**
     * Save an entity.
     * @param entity the entity to be saved
     * @return the persistent entity
     */
    public T save(final T entity) {
        getHibernateTemplate().save(entity);
        return entity;
    }

    /**
     * Saves or updates an entity.
     * @param entity the entity to be saved or updated
     * @return the persistent entity
     */
    public T saveOrUpdate(final T entity) {
        getHibernateTemplate().saveOrUpdate(entity);
        return entity;
    }

    /**
     * Update an entity.
     * @param entity the entity to be updated
     * @return the persistent entity
     */
    public T update(final T entity) {
        getHibernateTemplate().update(entity);
        return entity;
    }
}
