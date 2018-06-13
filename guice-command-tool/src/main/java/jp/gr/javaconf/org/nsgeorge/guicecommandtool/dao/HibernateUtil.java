package jp.gr.javaconf.org.nsgeorge.guicecommandtool.dao;

import jp.gr.javaconf.org.nsgeorge.guicecommandtool.entity.Person;
import com.google.inject.Inject;
import org.hibernate.*;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;

/**
 * @author Deepak Kumar
 * Web: http://www.roseindia.net
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private static ServiceRegistry serviceRegistry;

    // Static Initializer
    static {
        try {

            // Configurationインスタンス化
            Configuration conf = new Configuration()
                    // 引数なし : hibernate.cfg.xml
                    // 引数あり : 引数の設定ファイル
                    .addAnnotatedClass(Person.class)
                    .configure();

            serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(conf.getProperties()).build();

            // SessionFactory生成
            sessionFactory = conf.buildSessionFactory(serviceRegistry);
        } catch (Throwable th) {
            // DBに接続できない状況だと毎回エラーが出るので無視する
            //System.out.println("Enitial SessionFactory creation failed" + th);
            //throw new ExceptionInInitializerError(th);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Metadata getMetadata() {
        // Create a metadata sources using the specified service registry.
        return new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Person.class)
                .getMetadataBuilder()
                .build();
    }

    public static void closeSession() {
        if (HibernateUtil.getSessionFactory() instanceof SessionFactory) {
            HibernateUtil.getSessionFactory().close();
        }
    }
}