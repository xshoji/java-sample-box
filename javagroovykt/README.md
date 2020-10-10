
## groovy

```
$ groovy src/groovy/com/xshoji/SampleGroovy.groovy
```

## java

```
$ mkdir -p target/classes
$ kotlinc src/kotlin/com/xshoji/VoKotlin.kt -d target/classes/
$ javac -classpath ~/.m2/repository/org/jetbrains/kotlin/kotlin-stdlib/1.4.10/kotlin-stdlib-1.4.10.jar:~/.m2/repository/org/jetbrains/kotlin/kotlin-compiler/1.4.10/kotlin-compiler-1.4.10.jar:target/classes -d target src/java/com/xshoji/SampleJava.java
$ java -classpath ~/.m2/repository/org/jetbrains/kotlin/kotlin-stdlib/1.4.10/kotlin-stdlib-1.4.10.jar:~/.m2/repository/org/jetbrains/kotlin/kotlin-compiler/1.4.10/kotlin-compiler-1.4.10.jar:target/classes:target SampleJava
taroくん
10
```

 - [compile mixed Kotlin and Java code from the command line - Stack Overflow](https://stackoverflow.com/questions/33843753/compile-mixed-kotlin-and-java-code-from-the-command-line/45365418#45365418)

## kotlin

```
$ mkdir target
$ kotlinc-jvm src/kotlin/com/xshoji/VoKotlin.kt src/kotlin/com/xshoji/SampleKotlin.kt -include-runtime -d target/SampleKotlin.jar
$ java -cp $KOTLIN_HOME/lib/kotlin-runtime.jar -jar target/SampleKotlin.jar
print args
[Ljava.lang.String;@60215eee
hello world
taroくん
31
```

 - [Kotlinにチャレンジしてみる（HelloWorld) - Qiita](https://qiita.com/saba1024/items/d525fb6c89d1180b409a)
 - [5分でできる Kotlin + CLI で "Hello, World!" - Qiita](https://qiita.com/takuhiro/items/994a99611c97550a5d68)
