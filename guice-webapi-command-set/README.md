
# インストレーション

## Dockerホスト動作環境

```
$ docker --version
Docker version 17.03.1-ce, build c6d412e

$ git --version
git version 2.9.3 (Apple Git-75)
```





## 動かし方

```
$ git clone git@gitlab.com:george.n/helloapi.git
Cloning into 'helloapi'...
remote: Counting objects: 26, done.
remote: Compressing objects: 100% (18/18), done.
remote: Total 26 (delta 0), reused 0 (delta 0)
Receiving objects: 100% (26/26), 9.64 KiB | 0 bytes/s, done.
Checking connectivity... done.
$ cd helloapi/docker/
$ cp config.sh.dist config.sh
$ sh docker-compose.sh

...

    Name                   Command               State                           Ports
--------------------------------------------------------------------------------------------------------------
helloapi_java   /usr/bin/supervisord -n -- ...   Up      0.0.0.0:2222->22/tcp, 80/tcp, 0.0.0.0:18080->8080/tcp

Success!!
$ docker exec -it helloapi_java /bin/bash
[root@96be5cb5c011 src]#
[root@96be5cb5c011 app]# mvn --version
Apache Maven 3.5.0 (ff8f5e7444045639af65f6095c62210b5713f426; 2017-04-03T19:39:06Z)
Maven home: /opt/apache-maven-3.5.0
Java version: 1.8.0_102, vendor: Oracle Corporation
Java home: /usr/java/jdk1.8.0_102/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.9.13-moby", arch: "amd64", family: "unix"
[root@96be5cb5c011 app]#
[root@96be5cb5c011 src]# cd /app
[root@96be5cb5c011 src]# mvn package

...

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 01:04 min
[INFO] Finished at: 2017-04-29T17:30:16Z
[INFO] Final Memory: 20M/180M
[INFO] ------------------------------------------------------------------------
[root@96be5cb5c011 app]# mvn tomcat7:run
```

 - http://localhost:18080/helloapi/hello/call?name=taro

で`Hello! taro`って出る。

```
$ cd docker
$ docker-compose up -d
$ mvn package
$ mvn tomcat7:run
$ curl -H "Content-Type: application/json" localhost:8080/guice-webapi-command-set/hello/call?name=taro; echo
$ curl -H "Content-Type: application/json" localhost:8080/guice-webapi-command-set/hello/calc?x=1\&y=2; echo
$ java -jar target/guice-webapi-command-set-cli.jar
$ java -jar target/guice-webapi-command-set-cli.jar test call name
$ java -jar target/guice-webapi-command-set-cli.jar test sum 1 2
```




# やったこと

## Java8 + Maven8 + Tomcat9で動くようにした。

#### Java + Maven + Tomcatのコンテナを作成

 - javaインストール
 -

```
[root@247c51a571dc src]# java -version
java version "1.8.0_102"
Java(TM) SE Runtime Environment (build 1.8.0_102-b14)
Java HotSpot(TM) 64-Bit Server VM (build 25.102-b14, mixed mode)
[root@247c51a571dc src]# mvn --version
Apache Maven 3.5.0 (ff8f5e7444045639af65f6095c62210b5713f426; 2017-04-03T19:39:06Z)
Maven home: /opt/apache-maven-3.5.0
Java version: 1.8.0_102, vendor: Oracle Corporation
Java home: /usr/java/jdk1.8.0_102/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "4.9.13-moby", arch: "amd64", family: "unix"
[root@247c51a571dc src]# ps aux |grep tomcat
tomcat       8 13.1  4.4 2987300 90516 ?       Sl   16:19   0:04 /usr/java/default/bin/java -Djava.util.logging.config.file=/opt/apache-tomcat-9.0.0.M20/conf/logging.properties -Djava.util.logging.manager=org.apache.juli.ClassLoaderLogManager -Djdk.tls.ephemeralDHKeySize=2048 -Djava.protocol.handler.pkgs=org.apache.catalina.webresources -classpath /opt/apache-tomcat-9.0.0.M20/bin/bootstrap.jar:/opt/apache-tomcat-9.0.0.M20/bin/tomcat-juli.jar -Dcatalina.base=/opt/apache-tomcat-9.0.0.M20 -Dcatalina.home=/opt/apache-tomcat-9.0.0.M20 -Djava.io.tmpdir=/opt/apache-tomcat-9.0.0.M20/temp org.apache.catalina.startup.Bootstrap start
root       108  0.0  0.0 103384  2036 ?        R+   16:20   0:00 grep tomcat
[root@247c51a571dc src]#
```

#### MacにJavaとmavenをインストール

javaはOracleからjdkをダウンロードしてインストール。

mavenは

```
[04-30 00:53:56 ~]$ brew search maven
maven                      maven-completion           maven-shell                maven@3.1                  maven@3.2                  maven@3.3
Caskroom/cask/mavensmate
[04-30 00:54:06 ~]$ brew install maven@3.3
==> Using the sandbox
==> Downloading https://www.apache.org/dyn/closer.cgi?path=maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
==> Best Mirror http://ftp.yz.yamagata-u.ac.jp/pub/network/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
######################################################################## 100.0%
🍺  /usr/local/Cellar/maven@3.3/3.3.9: 95 files, 9.6MB, built in 7 seconds
[04-30 00:54:26 ~]$ mvn
^C[04-30 00:54:34 ~]$ mvn --version
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-11T01:41:47+09:00)
Maven home: /usr/local/Cellar/maven@3.3/3.3.9/libexec
Java version: 1.8.0_131, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre
Default locale: ja_JP, platform encoding: UTF-8
OS name: "mac os x", version: "10.12.4", arch: "x86_64", family: "mac"
[04-30 00:54:45 ~]$
```

でインストール。

#### mavenでプロジェクト作成

```
$ mvn archetype:generate -DgroupId=com.georgen.helloapi \
                         -DartifactId=helloapi \
                         -DarchetypeArtifactId=maven-archetype-webapp \
;
```

#### IntelliJでsrcをSource Directoryに設定

#### pom.xmlを編集してWebAPIで利用するモジュールを利用できる状態にする

pom.xmlの基本構成については

 - [Maven2のpom.xmlの構成 - tanamonの日記](http://d.hatena.ne.jp/tanamon/20080805/1217933963)

を参考に。

WebAPI向けの設定については

 - [Maven で Web アプリ用のプロジェクトを作成してからコーディングを着手するまでにやること](http://tomoyamkung.net/2013/07/13/java-maven-project-create/)

を参考にした。

#### コントローラークラス追加

```
[04-30 01:32:03 main]$ mkdir -p java/com/biggy/helloapi/controller
[04-30 01:32:03 main]$ touch java/com/biggy/helloapi/controller/HelloapiController.java
```
で、

 - [Maven2使い方メモ２（Tomcat で JAX-RS） - Qiita](http://qiita.com/opengl-8080/items/f36c570032e1a7555ed2)

 にしたがってソースをコピペして修正。

この段階だと、必要なPackageが入ってないので参照できない状態になっている。

#### packageの読み込み

IntelliJ上で、pom.xmlを右クリックしてmavenからreimportを選択して再読込するとライブラリを参照できるようになる。

#### WEBAPP配下のWEB-INF/web.xmlを削除する。アノテーションで指定しているため。

 - [Maven2使い方メモ２（Tomcat で JAX-RS） - Qiita](http://qiita.com/opengl-8080/items/f36c570032e1a7555ed2)

より。

#### container内のtomcatのwebappsディレクトリにwarファイルを配置する

```
$ cp /app/target/helloapi.war /opt/apache-tomcat-9.0.0.M20/webapps/
```

#### tomcatを起動する

```
$ sudo -u tomcat /opt/apache-tomcat-9.0.0.M20/bin/catalina.sh run
```

#### ブラウザでアクセスしてみる

http://localhost:18080/helloapi/sample

みれた！！





## サーバーインストール型のtomcatからmaven-plugin型のtomcatに変更してみる

まず、

 - [Java 最近のアプリケーションサーバー事情（2015年） - 技術ブログ | 株式会社クラウディア](https://cloudear.jp/blog/?p=985)

からtomcatが人気のよう。で、tomcatのバージョンを調べると最新は9らしい。

tomcat-maven-pluginなるものがあるらしいので、tomcat9向けのもの探したところ・・・ない。

それどころか、8向けのものもないらしい。主流のWebサーバーなのにどうなってるの？

 - [Tomcat 8 Maven Plugin for Java 8 - Stack Overflow](http://stackoverflow.com/questions/26883836/tomcat-8-maven-plugin-for-java-8)

一応　tomcat7-maven-plugin　でtomcat8へもデプロイできるらしいけど・・・。どうなんやこれ。

#### tomcat7-maven-pluginを入れてみる

 - [servletをlocal tomcat上で動かすまで - Qiita](http://qiita.com/Yutako/items/64140b2aa1ac4b71f1b5)

の通り、

```
    <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
        <version>2.2</version>
        <configuration>
            <port>9090</port>
            <server>localhost</server>
            <!--<path>/foo</path>-->
        </configuration>
    </plugin>
```

を追加

コンテナ上で

```
# mvn package
# mvn tomcat7:run
```

動いた





## URLによるルーティングをアノテーションで定義し、コントローラークラス内のメソッドごとに処理を割り振る

 - [Java - javax.servlet3系のルーティングに対するクラス／メソッド分けのプラクティスについて教えてください(74892)｜teratail](https://teratail.com/questions/74892)

で質問してみた。

どうやら、ServletはJavaの標準クラスを利用する実装方法のようで、アノテーションでルーティングを細かく制御することはできないみたい。

JAX-RSというライブラリを使えば、アノテーションでメソッドごとに処理を割り振れるみたいなので、それを使ってみる。

#### リソースクラスとアプリケーションクラスを実装

 - [JAX-RS入門および実践](https://backpaper0.github.io/ghosts/jaxrs-getting-started-and-practice.html#1)
 - [JAX-RSでRESTなWebサービスを作ってみる - うなの日記](http://unageanu.hatenablog.com/entry/20090723/1248353703)

を参考に、HelloapiControllerを修正、HelloapiApplicationを追加。

```
# mvn package
# mvn tomcat7:run
```

API動いていない・・・。

#### jersey-container-servletを追加した。

 - [Simple Jersey example with Intellij IDEA and Tomcat | chiaboy's Blog](https://chiaboy.wordpress.com/2014/07/20/simple-jersey-example-with-intellij-idea-and-tomcat/)
 - [web.xmlの記述 - アプリケーションの作成と配置 - サーブレット入門](https://www.javadrive.jp/servlet/context/index3.html)

に自分のやりたいことに近い話が書かれていたので参考にして修正してみる。

まず、pom.xmlに

```
    <dependency>
      <groupId>org.glassfish.jersey.containers</groupId>
      <artifactId>jersey-container-servlet</artifactId>
      <version>2.10.1</version>
    </dependency>
```

を追加。そのあと、webapp/WEB-INF/web.xmlを追加。

```
<?xml version="1.0" encoding="ISO-8859-1"?>
<web-app xmlns="http://java.sun.com/xml/ns/j2ee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd"
         version="2.4">

    <servlet>
        <servlet-name>jersey-servlet</servlet-name>
        <servlet-class>org.glassfish.jersey.servlet.ServletContainer</servlet-class>
        <init-param>
            <param-name>jersey.config.server.provider.packages</param-name>
            <param-value>com.georgen.helloapi</param-value>　←　ここだけ修正
            <load-on-startup>1</load-on-startup>
        </init-param>
    </servlet>

    <servlet-mapping>
        <servlet-name>jersey-servlet</servlet-name>
        <url-pattern>/*</url-pattern>
    </servlet-mapping>

</web-app>
```

で、

```
# mvn package
# mvn tomcat7:run
```

で、

 - [helloapi](http://localhost:18080/helloapi/hello/calc?x=1&y=2)

で動いた。web.xmlを追加しないといけないのが嫌やなぁ。




## コマンドラインで実行可能なwarファイルを作る

 - [java - How to run application from war? - Stack Overflow](http://stackoverflow.com/questions/8552336/how-to-run-application-from-war)

ここにそれに近い話が書いてあるかも。普通にそういうクラスを作って実行時にクラス名を指定すれば良い？

試しに、HelloapiCommandクラスを作ってみた。

```
/Users/shojinao/Develop/project_java/helloapi/src
|--main
|  |--java
|  |  |--com
|  |  |  |--biggy
|  |  |  |  |--helloapi
|  |  |  |  |  |--command
|  |  |  |  |  |  |--HelloapiCommand.java
```

```
[root@3f7457635137 app]# mvn package
[root@3f7457635137 app]# java -cp target/helloapi.war jp.gr.javaconf.org.nsgeorge.guicewebapicommandset.command.HelloapiCommand test
Error: Could not find or load main class jp.gr.javaconf.org.nsgeorge.guicewebapicommandset.command.HelloapiCommand
[root@3f7457635137 app]#
```

できなかった。





## WebAppであるwarとコマンドラインで実行可能なjarを作る

 - [Mavenでwarと実行可能jarを同時にビルドする - Qiita](http://qiita.com/mocchii/items/1660929982246c7f135b)

まさにこれや！という感じ。早速試してみる。

まずは、`assembly/executable-jar.xml`を追加。

```
<assembly
        xmlns="http://maven.apache.org/plugins/maven-assembly-plugin/assembly/1.1.2"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/plugins/maven-assembly-plugin/assembly/1.1.2 http://maven.apache.org/xsd/assembly-1.1.2.xsd">

    <id>make-jar</id>
    <formats>
        <format>jar</format>
    </formats>


    <fileSets>
        <fileSet>
            <directory>${project.basedir}/src/main/assembly</directory>
            <outputDirectory>/</outputDirectory>
            <excludes>
                <exclude>executable-jar.xml</exclude>
            </excludes>
        </fileSet>
    </fileSets>

    <includeBaseDirectory>false</includeBaseDirectory>
    <dependencySets>
        <dependencySet>
            <outputDirectory>/</outputDirectory>
            <useProjectArtifact>true</useProjectArtifact>
            <unpack>true</unpack>
            <scope>runtime</scope>
        </dependencySet>
    </dependencySets>

</assembly>
```

※logbackのところは今は一旦使わないので抜いてみた。

次に、pom.xmlに以下を追加。

```
...
      <!-- jar作成用 -->
      <plugin>
        <artifactId>maven-assembly-plugin</artifactId>
        <version>2.5</version>
        <executions>
          <execution>
            <id>make-jar</id>
            <phase>compile</phase><!-- packageじゃなくて、compileを指定 -->
            <goals>
              <goal>single</goal>
            </goals>
          </execution>
        </executions>
        <configuration>
          <descriptors><!-- 独自定義ファイルの指定 -->
            <descriptor>src/main/assembly/executable-jar.xml</descriptor>
          </descriptors>
          <finalName>helloapi_command</finalName>
          <appendAssemblyId>false</appendAssemblyId>
          <archive>
            <manifest>
              <mainClass>jp.gr.javaconf.org.nsgeorge.guicewebapicommandset.command.HelloapiCommand</mainClass>
            </manifest>
          </archive>
        </configuration>
      </plugin>
...

[root@3f7457635137 app]# mvn package
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building helloapi Maven Webapp 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------

...

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 9.119 s
[INFO] Finished at: 2017-05-07T07:53:04Z
[INFO] Final Memory: 16M/189M
[INFO] ------------------------------------------------------------------------
[root@3f7457635137 app]# java -jar target/command_helloapi.jar jp.gr.javaconf.org.nsgeorge.guicewebapicommandset.command.HelloapiCommand call tom!
Hello! tom!
[root@3f7457635137 app]# java -jar target/command_helloapi.jar jp.gr.javaconf.org.nsgeorge.guicewebapicommandset.command.HelloapiCommand sum 1 2
x:1 + y:2 = sum:3
[root@3f7457635137 app]#
```

できた！！





## サービス層を追加

 - Caller: Hello! XXXの文字列を返してくれる
 - Calculator: 数値の足し算、足し算し結果の式の文字列を返してくれる

みたいなサービス層のクラスを仮に立ててみて、ControllerとCommandクラスから呼び出すように修正。

```
[root@3f7457635137 app]# mvn package
[INFO] Scanning for projects...
[INFO]

...

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 11.727 s
[INFO] Finished at: 2017-05-07T08:12:49Z
[INFO] Final Memory: 21M/196M
[INFO] ------------------------------------------------------------------------
[root@3f7457635137 app]# java -jar target/command_helloapi.jar jp.gr.javaconf.org.nsgeorge.guicewebapicommandset.command.HelloapiCommand call hideo
Hello! hideo
[root@3f7457635137 app]# java -jar target/command_helloapi.jar jp.gr.javaconf.org.nsgeorge.guicewebapicommandset.command.HelloapiCommand sum 1 2
x:1 + y:2 = sum:3
[root@3f7457635137 app]# mvn tomcat7:run
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building helloapi Maven Webapp 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------

...

[INFO] --- tomcat7-maven-plugin:2.2:run (default-cli) @ helloapi ---
[INFO] Running war on http://localhost:8080/helloapi
[INFO] Creating Tomcat server configuration at /app/target/tomcat
[INFO] create webapp with contextPath: /helloapi
May 07, 2017 8:13:11 AM org.apache.coyote.AbstractProtocol init
INFO: Initializing ProtocolHandler ["http-bio-8080"]


[root@3f7457635137 src]# curl http://localhost:8080/helloapi/hello/call?name=hideo; echo ""
Hello! hideo
[root@3f7457635137 src]# curl http://localhost:8080/helloapi/hello/calc?x=1\&y=2; echo ""
x:1 + y:2 = sum:3
[root@3f7457635137 src]#
```

うまく動いた！

## Loggerが使えるように、Logbackを導入する

#### pom.xmlに依存を追加

 - [Logback のシンプルな使い方 (Java) - Qoosky](https://www.qoosky.io/techs/56a449e9e7)

```
    <dependency>
      <groupId>ch.qos.logback</groupId>
      <artifactId>logback-classic</artifactId>
      <version>1.1.3</version>
    </dependency>
    <dependency>
      <groupId>org.slf4j</groupId>
      <artifactId>slf4j-api</artifactId>
      <version>1.7.12</version>
    </dependency>
```

また、参考ページにもあるとお、logback.xmlの場所を変更する場合は、以下で指定するようです。今回は指定しません。

```
...
  <build>
    <resources>
      <resource>
        <directory>${basedir}/src</directory>
        <includes>
          <include>**/*.xml</include>
        </includes>
      </resource>
    </resources>
...
```

ログ出力場所を絶対パスにします。

 - [maven-resources-pluginのフィルタリングを使って設定ファイル内で変数置換 - Qiita](http://qiita.com/kozy4324/items/9fa17a98203761012fd9)
 - [Maven – Introduction to the POM](http://maven.apache.org/guides/introduction/introduction-to-the-pom.html#Project_Interpolation_and_Variables)

の通り、pom.xmlに以下を追加し

```
  <!-- ■　main/resourcesの各種xmlファイルに注入するプロパティ値 -->
  <properties>
    <logback.log.dir>/app/target/logs</logback.log.dir>
  </properties>

```

`main/resources/logback.xml`を以下の様に修正した。

```
    <property name="LOG_DIR" value="./logs" />
    ↓
    <property name="LOG_DIR" value="${logback.log.dir}" />
```

で、package, 実行で当該ディレクトリが作られて出力されるようになった。





## DBをマイグレーションできるようにする

 - [Maven - First Steps - Flyway by Boxfuse • Database Migrations Made Easy.](https://flywaydb.org/getstarted/firststeps/maven)

の通り、pom.xmlに以下を追加

```
  <!-- ■　main/resourcesの各種xmlファイルに注入するプロパティ値 -->
  <properties>
    <logback.log.dir>/tmp/logs</logback.log.dir>
    <database.jcdb_url>jdbc:postgresql://db:5432/postgres</database.jcdb_url>
    <database.user>postgres</database.user>
    <database.pass>postgres</database.pass>
  </properties>

...

      <!-- Database migration -->
      <!-- MyBatis Migrationでテーブルスキーマの構成管理をする - Qiita http://qiita.com/nyasba/items/a67da27d5130f48ffc6c -->
      <plugin>
        <groupId>org.flywaydb</groupId>
        <artifactId>flyway-maven-plugin</artifactId>
        <version>4.2.0</version>
        <configuration>
          <url>${database.jcdb_url}</url>
          <user>${database.user}</user>
          <password>${database.pass}</password>
        </configuration>
      </plugin>

...

    <!-- https://mvnrepository.com/artifact/postgresql/postgresql -->
    <dependency>
      <groupId>postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>9.1-901-1.jdbc4</version>
    </dependency>
```

をそれぞれ追加。postgresqlのドライバは、エラーが出るので追加。

```
# mvn package
# mvn flyway:migrate

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.724 s
[INFO] Finished at: 2017-05-08T16:21:48Z
[INFO] Final Memory: 11M/95M
[INFO] ------------------------------------------------------------------------
```

なんとなくビルドと実行は成功した。

#### テーブルを作ってみる

 - `src/main/resources/db/migration/V1__Create_person_table.sql`を追加
 - `mvn flyway:migrate`を実行

直接コンテナに入って確認してみる。

```
[05-09 01:28:17 ~]$ docker exec -it helloapi_postgresql psql -hdb -Upostgres postgres
Password for user postgres:
psql (9.4.11)
Type "help" for help.

postgres=#
postgres=# \d
             List of relations
 Schema |      Name      | Type  |  Owner
--------+----------------+-------+----------
 public | person         | table | postgres
 public | schema_version | table | postgres
(2 rows)

postgres=#
```

できてた！

## mybatisを導入してDBの操作を楽にする

 - [MyBatis 使い方メモ - Qiita](http://qiita.com/opengl-8080/items/a9b5d4038f19d4813ee6)

pom.xmlに以下を追加

```
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.4.4</version>
</dependency>
```

 - `resources/mybatis-config.xml`を追加
     - `resources/mybatis-mapper.xml`は使わず、直接`<mapper class="jp.gr.javaconf.org.nsgeorge.guicewebapicommandset.repository.mapper.PersonRepository"/>`を指定する
 - `src/main/java/com/georgen/helloapi/entity/Person.java`を追加
     - [6.2. データベースアクセス（MyBatis3編） — TERASOLUNA Server Framework for Java (5.x) Development Guideline 5.3.0.RELEASE documentation](http://terasolunaorg.github.io/guideline/5.3.0.RELEASE/ja/ArchitectureInDetail/DataAccessDetail/DataAccessMyBatis3.html#dataaccessmybatis3howtousesettingsmybatis3)
     - [3.2. ドメイン層の実装 — TERASOLUNA Server Framework for Java (5.x) Development Guideline 5.3.0.RELEASE documentation](http://terasolunaorg.github.io/guideline/5.3.0.RELEASE/ja/ImplementationAtEachLayer/DomainLayer.html#id8)
 - `src/main/java/com/georgen/helloapi/repository/PersonRepository.java`を追加
 - `src/main/java/com/georgen/helloapi/service/MyBatisManager.java`を追加
     - [MyBatis 3 Annotation Example with @Select, @Insert, @Update and @Delete](http://www.concretepage.com/mybatis-3/mybatis-3-annotation-example-with-select-insert-update-and-delete)
 - `add`を使う処理をCommandクラスに実装する
     - [java - MyBatis 3.0.1 insert problem - Stack Overflow](http://stackoverflow.com/questions/3105876/mybatis-3-0-1-insert-problem)

#### java.io.IOException: Could not find resource /mybatis-config.xmlってでる

 - [java - could not find resouce in mybatis - Stack Overflow](http://stackoverflow.com/questions/38763568/could-not-find-resouce-in-mybatis)

の通り、`Resources.getResourceAsReader`を使うようにする。

```
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
```

#### Entityのプロパティとテーブルの型を一致させないといけない。

 - int id: Integer Idなど

#### Repositoryクラスの処理は、`@PARAM`アノテーションをつけてどのプロパティとマッピングさせるか指定する

 - [MyBatis - selectKeyのkeyPropertyが効かずBindingExceptionが発生してしまう(28999)｜teratail](https://teratail.com/questions/28999)
 - [BindingException: Parameter 'a' not found. Available parameters are [param1, b] for the case when I use xml query building and one query for several Mapper-methods. · Issue #417 · mybatis/mybatis-3](https://github.com/mybatis/mybatis-3/issues/417)

```
    @Insert("INSERT into person(id, name) VALUES(#{id}, #{name})")
    void add(@Param("id") Integer id, @Param("name") String name);
```

#### リポジトリのメソッドを呼ぶ時はトランザクションを意識して、commitを明示的に呼び出す

```
    /**
     *
     * @param id
     * @param name
     */
    public static void add(Integer id, String name)
    {
        // mybatis – MyBatis 3 | Getting started http://www.mybatis.org/mybatis-3/getting-started.html
        SqlSession session = MyBatisManager.getSqlSessionFactory().openSession();
        PersonRepository repository = session.getMapper(PersonRepository.class);
        repository.add(id, name);
        System.out.println("added!");
        session.commit();　←　これ
    }

```

**結果**

```
# [root@78d330111e2f app]# mvn package
# [root@78d330111e2f app]# java -jar target/command_helloapi.jar jp.gr.javaconf.org.nsgeorge.guicewebapicommandset.command.Hello add 3 taro
  mode : add
  args count : 4
  added!
```

できた！

## mybatisを使ってRepositoryパターンで実装してみる

 - [【Spring】MyBatisフレームワークの導入 - Qiita](http://qiita.com/kyazawa/items/6d2558064b868396a477)

pom.xmlに以下を追加。

```
    <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>1.3.0</version>
    </dependency>
```

で、前作ったRepositoryクラスをMapperクラスとして、リネームし、本物のRepositoryクラスを作る。

 - [Google Guice 使い方メモ - Qiita](http://qiita.com/opengl-8080/items/6fb69cd2493e149cac3a#provides-%E3%83%A1%E3%82%BD%E3%83%83%E3%83%89%E3%81%A7%E3%82%A4%E3%83%B3%E3%82%B8%E3%82%A7%E3%82%AF%E3%82%B7%E3%83%A7%E3%83%B3%E3%81%99%E3%82%8B%E3%82%A4%E3%83%B3%E3%82%B9%E3%82%BF%E3%83%B3%E3%82%B9%E3%82%92%E5%AE%9A%E7%BE%A9%E3%81%99%E3%82%8B)
 - [Google Guice Dependency Injection Example Tutorial - JournalDev](http://www.journaldev.com/2403/google-guice-dependency-injection-example-tutorial)

を見ながらざくっと導入してみる。

```
# [root@78d330111e2f app]# mvn package
# [root@78d330111e2f app]# java -jar target/command_helloapi.jar jp.gr.javaconf.org.nsgeorge.guicewebapicommandset.command.Hello add 5 taro2
id: 5 | name: taro2
```

一応できた！

#### GoogleGuiceのコンフィグ部分をまとめる

 - [Google Guice Dependency Injection Example Tutorial - JournalDev](http://www.journaldev.com/2403/google-guice-dependency-injection-example-tutorial)

を参考に、AppInjectorを定義。こいつで全てのサービスの依存を管理する。

できた！AppInjectorで依存を管理できるようになった。


# FAQ

## javaの標準パッケージimport時にCannot findになってしまう

プロジェクトのルートディレクトリを右クリックして、

Open Module Setting -> Project -> Module SDKをJava1.8にする





# References

 - [Maven で Web アプリ用のプロジェクトを作成してからコーディングを着手するまでにやること](http://tomoyamkung.net/2013/07/13/java-maven-project-create/)
 - [Maven2使い方メモ２（Tomcat で JAX-RS） - Qiita](http://qiita.com/opengl-8080/items/f36c570032e1a7555ed2)
 - [Mavenを利用してSpring MVCの開発をする - Qiita](http://qiita.com/527aboo/items/f61912f28d68f4e084b0)

 - [Apache Maven Dependency Plugin – dependency:resolve](http://maven.apache.org/plugins/maven-dependency-plugin/resolve-mojo.html)
 - [Maven – POM Reference](https://maven.apache.org/pom.html#Dependencies)
 - [Mavenリポジトリにないライブラリをpom.xmlで指定する方法 - システム開発メモ](http://progmemo.wp.xdomain.jp/archives/1094)
 - [Mavenでプロジェクトの依存関係を解析する - CLOVER](http://d.hatena.ne.jp/Kazuhira/20121206/1354805445)

 - [Maven2のpom.xmlの構成 - tanamonの日記](http://d.hatena.ne.jp/tanamon/20080805/1217933963)
 - [MavenプロジェクトをTomcatで動かす方法 - Qiita](http://qiita.com/gishi_yama/items/32d811cbb10d50912fc3)
 - [kakakikikekeのブログ: eclipseでmavenプロジェクトとTomcat7を連携する方法（デプロイ）](http://blog.kakakikikeke.tk/2013/08/eclipsemaventomcat7.html)
