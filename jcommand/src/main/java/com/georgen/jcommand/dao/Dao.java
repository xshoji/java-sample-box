package com.georgen.jcommand.dao;

import com.google.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

abstract public class Dao<E > {

    @Inject
    protected SessionFactory sessionFactory;

    public Dao() {
    }

    protected Session getSession() {
        return this.sessionFactory.openSession();
    }
}
