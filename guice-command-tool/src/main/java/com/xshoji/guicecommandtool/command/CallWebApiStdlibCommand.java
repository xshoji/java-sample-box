package com.xshoji.guicecommandtool.command;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class CallWebApiStdlibCommand extends Command {


  /**
   * @param args
   * @link Jackson使い方メモ - Qiita http://qiita.com/opengl-8080/items/b613b9b3bc5d796c840c
   * @link java - NoClassDefFoundError of com/fasterxml/jackson/databind/ObjectMapper with Maven https://stackoverflow.com/questions/43826718/noclassdeffounderror-of-com-fasterxml-jackson-databind-objectmapper-with-maven
   */
  protected void doRun(String[] args) {
    String responseJson = "";
    try {
      URLConnection connection = URI.create("https://httpbin.org/get?param1=test").toURL().openConnection();
      try (InputStream inputStream = connection.getInputStream()) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        bufferedReader.lines().forEach(sb::append);
        responseJson = sb.toString();
        this.systemOutPrintln("response json: ");
        this.systemOutPrintln(responseJson);
      } finally {
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    // java - Retrieving values from nested JSON Object - Stack Overflow https://stackoverflow.com/questions/20899839/retrieving-values-from-nested-json-object
    this.systemOutPrintln("json contents extraction: ");

    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = null;
    try {
      root = mapper.readTree(responseJson);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // Java 向け JSON ライブラリ Jackson でデータを読み込む - blog.kymmt.com http://blog.kymmt.com/entry/jackson
    JsonNode jsonHeaders = root.get("headers");
    JsonNode jsonArgs = root.get("args");
    this.systemOutPrintln("    origin: " + root.get("origin").asText());
    this.systemOutPrintln("       url: " + root.get("url").asText());
    this.systemOutPrintln("      args:");
    this.systemOutPrintln("      param1: " + jsonArgs.get("param1").asText());
    this.systemOutPrintln("   headers:");
    this.systemOutPrintln("      Accept: " + jsonHeaders.get("Accept").asText());
    this.systemOutPrintln("  Connection: " + jsonHeaders.get("Connection").asText());
    this.systemOutPrintln("        Host: " + jsonHeaders.get("Host").asText());
    this.systemOutPrintln("  User-Agent: " + jsonHeaders.get("User-Agent").asText());


  }
}
