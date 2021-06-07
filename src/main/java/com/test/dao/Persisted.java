package com.test.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.test.model.Customer;

public class Persisted {

    private EntityManager em;

    public Persisted(EntityManager em) {
        this.em = em;
    }

    public void save(Customer entity) {
        em.persist(entity);
    }

    public Customer findById(Long id) {
        return em.find(Customer.class, id);
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
