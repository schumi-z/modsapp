package hu.modsstore.model.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic DAO interface. Every DAO object must implement this.
 * @author Bertalan_Kis
 * @param <T> T is the type of the entity
 * @param <I> I is type of the id
 */

public interface GenericDAO < T , I extends Serializable > {
    /**
     * Save an entity.
     * @param entity the entity to be saved
     * @return the persistent entity
     */
    T save(T entity);
    /**
     * Update an entity.
     * @param entity the entity to be updated
     * @return the persistent entity
     */
    T update(T entity);
    /**
     * Saves or updates an entity.
     * @param entity the entity to be saved or updated
     * @return the persistent entity
     */
    T saveOrUpdate(T entity);

    /**
     * Locates a persistent entity by it's id.
     * @param entityId the id of the entity
     * @return the persistent object or null if not exists
     */
    T findById(I entityId);

    /**
     * Finds all the entities for this DAO.
     * @return a list of entities (can be empty list)
     */

    List < T > listAll();
     /**
     * Deletes the given entity.
     * @param entityId the id of the entity
     */

    void deleteById(I entityId);
    /**
     * Deletes the given entity.
     * @param entity the entity to be deleted
     */
    void delete(Object entity);
}
