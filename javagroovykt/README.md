
```
$ pwd
/.../java-sample-box/javagroovykt
```

## groovy

```
$ groovy src/groovy/sample/SampleGroovy.groovy
```

## java

```
$ mkdir -p target/classes
$ kotlinc src/kotlin/sample/VoKotlin.kt -d target/classes/
$ javac -classpath ~/.m2/repository/org/jetbrains/kotlin/kotlin-stdlib/1.2.31/kotlin-stdlib-1.2.31.jar:~/.m2/repository/org/jetbrains/kotlin/kotlin-compiler/1.2.31/kotlin-compiler-1.2.31.jar:target/classes -d target src/java/sample/SampleJava.java
$ java -classpath ~/.m2/repository/org/jetbrains/kotlin/kotlin-stdlib/1.2.31/kotlin-stdlib-1.2.31.jar:~/.m2/repository/org/jetbrains/kotlin/kotlin-compiler/1.2.31/kotlin-compiler-1.2.31.jar:target/classes:target SampleJava
naoくん
10
```

 - [compile mixed Kotlin and Java code from the command line - Stack Overflow](https://stackoverflow.com/questions/33843753/compile-mixed-kotlin-and-java-code-from-the-command-line/45365418#45365418)

## kotlin

```
$ mkdir target
$ kotlinc-jvm src/kotlin/sample/VoKotlin.kt src/kotlin/sample/SampleKotlin.kt -include-runtime -d target/SampleKotlin.jar
$ java -cp $KOTLIN_HOME/lib/kotlin-runtime.jar -jar target/SampleKotlin.jar
hello world
taroくん
31
```

 - [Kotlinにチャレンジしてみる（HelloWorld) - Qiita](https://qiita.com/saba1024/items/d525fb6c89d1180b409a)
 - [5分でできる Kotlin + CLI で "Hello, World!" - Qiita](https://qiita.com/takuhiro/items/994a99611c97550a5d68)
