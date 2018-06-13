package jp.gr.javaconf.org.nsgeorge.helloapi.repository;

import jp.gr.javaconf.org.nsgeorge.helloapi.entity.Person;
import jp.gr.javaconf.org.nsgeorge.helloapi.repository.mapper.PersonMapper;
import com.google.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PersonRepositroy
{

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public Person findOne(Integer id)
    {
        SqlSession session = this.sqlSessionFactory.openSession();
        Person person = session.getMapper(PersonMapper.class).findOne(id);
        session.close();
        return person;
    }

    public void add(Integer id, String name)
    {
        SqlSession session = this.sqlSessionFactory.openSession();
        Person person_exists = this.findOne(id);
        Person person_new;

        if (person_exists instanceof Person == false) {
            person_new = new Person();
            person_new.setId(id);
            person_new.setName(name);
            session.getMapper(PersonMapper.class).add(person_new);
            session.commit();
        }
    }

}