package jp.gr.javaconf.org.nsgeorge.guicewebapicommandset;


import jp.gr.javaconf.org.nsgeorge.guicewebapicommandset.service.MyBatisManager;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.apache.ibatis.session.SqlSessionFactory;

public class AppInjector extends AbstractModule {

    @Override
    protected void configure() {}

    @Provides
    // Google Guice 使い方メモ - Qiita http://qiita.com/opengl-8080/items/6fb69cd2493e149cac3a#provides-%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89%E3%81%A7%E3%82%A4%E3%83%B3%E3%82%B8%E3%82%A7%E3%82%AF%E3%82%B7%E3%83%A7%E3%83%B3%E3%81%99%E3%82%8B%E3%82%A4%E3%83%B3%E3%82%B9%E3%82%BF%E3%83%B3%E3%82%B9%E3%82%92%E5%AE%9A%E7%BE%A9%E3%81%99%E3%82%8B
    private SqlSessionFactory provideSqlSessionFactory() {
        return MyBatisManager.getSqlSessionFactory();
    }

}
