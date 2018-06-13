# guice-command-tool

コマンドラインツールをビルドする場合のサンプルプロジェクト

## Installation and Run sample command

## History

```
$ mvn archetype:generate -DgroupId=com.georgen.jcommand -DartifactId=simpleconsole -DarchetypeArtifactId=maven-archetype-quickstart
```

 - [args4j parent - How to use Args4J](http://args4j.kohsuke.org/sample.html)
 - [Javaの実行コマンドとクラスパスの指定、jarにパスを通して実行する方法など - Going my way](http://gomyownway.hatenablog.com/entry/2012/08/07/205009)

Add Sample.java

```
$ javac -classpath ~/.m2/repository/args4j/args4j/2.33/args4j-2.33.jar src/main/java/com/georgen/jcommand/Sample.java -d target/
```

## Open on IntelliJ

open from version conrol system -> git -> maven -> OK, OK ,...

If you saw following message when run unit test,

```
... Class JavaLaunchHelper is implemented in both ...
```

Help -> Edit Custom Properties -> add `idea.no.launcher=true`

 - java - objc[3648]: Class JavaLaunchHelper is implemented in both - Stack Overflow https://stackoverflow.com/questions/43003012/objc3648-class-javalaunchhelper-is-implemented-in-both

#### Install SDKMAN and Groovy

```
$ curl -s api.sdkman.io | bash
$ sdk list groovy
$ sdk install groovy 2.4.9
$ groovy -v
Groovy Version: 2.4.9 JVM: 1.8.0_131 Vendor: Oracle Corporation OS: Mac OS X
```


# Build and Run

```
// Build as "dev" environment
$ mvn clean package -Pdev
$ java -jar target/jcommand-0.0.1-make-jar.jar
$ java -jar target/jcommand-0.0.1-make-jar.jar SampleCommand -h
$ java -jar target/jcommand-0.0.1-make-jar.jar SampleCommand -title Taro
```

### Build and Run without test

```
$ mvn clean package -Pdev -Dmaven.test.skip=true && java -jar target/jcommand-0.0.1-make-jar.jar PrintPropertiesCommand
```

# Run unit test

```
$ mvn clean test
```

## FAQ

```
Tests run: 5, Failures: 0, Errors: 5, Skipped: 0, Time elapsed: 2.125 sec <<< FAILURE! - in com.georgen.jcommand.CommandFactoryTest
Command Factory#Error:createCommand(com.georgen.jcommand.CommandFactoryTest)  Time elapsed: 1.808 sec  <<< ERROR!
com.google.inject.internal.util.$ComputationException: java.lang.ArrayIndexOutOfBoundsException: 1139
```

You should run database.






# References

```
Using Google Guice to to inject java properties - Stack Overflow
https://stackoverflow.com/questions/9772557/using-google-guice-to-to-inject-java-properties/21331918


google guice inject value - Google 検索
https://www.google.co.jp/search?q=google+guice+maven+property+injection&oq=google+guice+maven+&aqs=chrome.1.69i59l2j69i57j69i59j0l2.9332j0j4&sourceid=chrome&ie=UTF-8#q=google+guice+inject+value&tbas=0


java - Guice and properties files - Stack Overflow
https://stackoverflow.com/questions/3071891/guice-and-properties-files


テックノート – 【Maven】profilesを使って、環境毎に異なる設定値(propertyファイル)を変更する方法
http://javatechnology.net/other/maven-profiles/


Binding Names to Multiple Properties File - Google グループ
https://groups.google.com/forum/#!topic/google-guice/XfQtciyD-94


Google Guice: Agile Lightweight Dependency Injection Framework - Robbie Vanbrabant - Google ブックス
https://books.google.co.jp/books?id=s9Yr6gnhE90C&pg=PA43&lpg=PA43&dq=google+guice+getResourceAsStream&source=bl&ots=-UhfVP4zEZ&sig=i4g_UQe1j-jmaxmYpOqld_2-EEA&hl=ja&sa=X&ved=0ahUKEwjF4KXQ0JrUAhUBuJQKHcX0B5kQ6AEIaTAI#v=onepage&q=google%20guice%20getResourceAsStream&f=false


java - getResourceAsStream() is returning null. Properties file is not loading - Stack Overflow
https://stackoverflow.com/questions/18053059/getresourceasstream-is-returning-null-properties-file-is-not-loading


Java - javaで実装上特に不要だがinterfaceを継承する設計(29968)｜teratail
https://teratail.com/questions/29968

(その10) 同じ型で異なる実装クラスをinjectしたい場合 - あるまに
http://d.hatena.ne.jp/arumani/20070316/1174056699

Creating multiple instances of the same object with different dependencies - Google グループ
https://groups.google.com/forum/#!topic/google-guice/RCBw_I-H45g

FrequentlyAskedQuestions · google/guice Wiki
https://github.com/google/guice/wiki/FrequentlyAskedQuestions

MavenプロジェクトでOracleのJDBCドライバを使いたい - 覚えたら書く
http://blog.y-yuki.net/entry/2016/11/24/000000

Hibernateを動かした - kagamihogeの日記
http://kagamihoge.hatenablog.com/entry/20120103/1325585737

Hibernate - 試してみようサンプル - liguofeng29’s blog
http://javait.hatenablog.com/entry/2016/07/03/103442
```

