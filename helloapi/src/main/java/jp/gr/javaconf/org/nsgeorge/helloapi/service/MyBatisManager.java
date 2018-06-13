package jp.gr.javaconf.org.nsgeorge.helloapi.service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisManager {

    private static SqlSessionFactory sqlSessionFactory;

    /**
     * static イニシャライザというらしい。
     */
    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return SqlSession
     */
    public static SqlSessionFactory getSqlSessionFactory()
    {
        return sqlSessionFactory;
    }
}