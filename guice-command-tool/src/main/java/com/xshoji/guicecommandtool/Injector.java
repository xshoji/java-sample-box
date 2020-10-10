package com.xshoji.guicecommandtool;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;
import com.xshoji.guicecommandtool.dao.HibernateUtil;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Injector extends AbstractModule {

  protected Properties properties;

  @Override
  protected void configure() {
    loadProperties();
  }

  /**
   * @link Flexible configuration with Guice « Otaku, Cedric's blog http://beust.com/weblog/2013/07/12/flexible-configuration-with-guice/
   * @link Guice による依存性注入 https://www.ibm.com/developerworks/jp/java/library/j-guice.html
   * @link Google Guice 使い方メモ - Qiita http://qiita.com/opengl-8080/items/6fb69cd2493e149cac3a#provides-%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89%E3%81%A7%E3%82%A4%E3%83%B3%E3%82%B8%E3%82%A7%E3%82%AF%E3%82%B7%E3%83%A7%E3%83%B3%E3%81%99%E3%82%8B%E3%82%A4%E3%83%B3%E3%82%B9%E3%82%BF%E3%83%B3%E3%82%B9%E3%82%92%E5%AE%9A%E7%BE%A9%E3%81%99%E3%82%8B
   */
  private void loadProperties() {
    InputStream stream = Injector.class.getResourceAsStream("/app.properties");

    try {
      this.properties = new Properties();
      this.properties.load(stream);
      Names.bindProperties(binder(), this.properties);
    } catch (IOException e) {
      // This is the preferred way to tell Guice something went wrong
      binder().addError(e);
    }
  }

  /**
   * @return
   * @link http://qiita.com/opengl-8080/items/6fb69cd2493e149cac3a#provides-%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89%E3%81%A7%E3%82%A4%E3%83%B3%E3%82%B8%E3%82%A7%E3%82%AF%E3%82%B7%E3%83%A7%E3%83%B3%E3%81%99%E3%82%8B%E3%82%A4%E3%83%B3%E3%82%B9%E3%82%BF%E3%83%B3%E3%82%B9%E3%82%92%E5%AE%9A%E7%BE%A9%E3%81%99%E3%82%8B
   */
  @Provides
  public CloseableHttpClient provideCloseableHttpClient() {
    return HttpClients.createDefault();
  }

  @Provides
  public Logger provideLogger() {
    return LoggerFactory.getLogger(this.properties.getProperty("logback.log.name"));
  }

  @Provides
  public SessionFactory provideSessionFactory() {
    return HibernateUtil.getSessionFactory();
  }

  @Provides
  public Metadata provideMetadata() {
    return HibernateUtil.getMetadata();
  }
}
