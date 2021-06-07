package com.test.dao;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Persisted<E, K> {

    private EntityManager em;

    private Class<E> clazz;

    @SuppressWarnings("unchecked")
    public Persisted(EntityManager em) {
        this.em = em;
        this.clazz = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void save(E entity) {
        em.persist(entity);
    }

    public E findById(K id) {
        return em.find(clazz, id);
    }

    public void commit() {
        EntityTransaction trx = null;
        try {
            trx = em.getTransaction();
            trx.begin();
            em.flush();
            trx.commit();
        } catch (Exception e) {
            if (trx != null) {
                trx.rollback();
            }
            e.printStackTrace();
        }
    }
}
