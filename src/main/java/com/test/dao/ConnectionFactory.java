package com.test.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

    private static final String PERSISTENCE_UNIT = "jsf-with-oracledb-persistence-unit";

    private static EntityManagerFactory factory;

    private ConnectionFactory() {
    }

    public static final EntityManagerFactory getInstance() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return factory;
    }
}
