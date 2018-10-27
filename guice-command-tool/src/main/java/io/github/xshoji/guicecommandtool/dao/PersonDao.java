package io.github.xshoji.guicecommandtool.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import io.github.xshoji.guicecommandtool.entity.Person;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PersonDao extends Dao {


    public void save(Person person) {
        Session session = this.getSession();

        // TX開始
        Transaction tx = session.beginTransaction();
        session.save(person);
        tx.commit();
        session.close();
    }

    public Person find(Long id) {
        Session session = this.getSession();

        // loadすると
        // Exception in thread "main" org.hibernate.LazyInitializationException: could not initialize proxy - no Sessionが発生する
        // person person = (person) session.load(person.class, id);
        Person person = (Person) session.get(Person.class, id);
        session.close();

        return person;
    }

    public void update(Person person) {
        Session session = this.getSession();

        // TX開始
        Transaction tx = session.beginTransaction();
        session.update(person);
        tx.commit();
        session.close();
    }

    public void delete(Person person) {
        Session session = this.getSession();

        // TX開始
        Transaction tx = session.beginTransaction();
        session.delete(person);
        tx.commit();
        session.close();
    }

    public List<Person> findAll() {

        Session session = getSession();

        // java - Deprecated createCriteria method in Hibernate - Stack Overflow
        // https://stackoverflow.com/questions/40720799/deprecated-createcriteria-method-in-hibernate

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        criteria.from(Person.class);

        @SuppressWarnings("unchecked")
        List<Person> list = session.createQuery(criteria).list();

        session.close();

        return list;
    }
}
