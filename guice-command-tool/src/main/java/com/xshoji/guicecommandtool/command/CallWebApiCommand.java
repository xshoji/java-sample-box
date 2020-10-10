package com.xshoji.guicecommandtool.command;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.xshoji.guicecommandtool.dto.ResponseHttpbinGet;
import com.xshoji.guicecommandtool.dto.ResponseHttpbinPost;
import com.xshoji.guicecommandtool.service.ApiClientHttpbin;
import org.kohsuke.args4j.Option;

public class CallWebApiCommand extends Command {

  @Option(name = "-title", usage = "Sets a title", required = true)
  public String title;

  @Inject
  protected ApiClientHttpbin apiClient;

  /**
   * @param args
   * @link Jackson使い方メモ - Qiita http://qiita.com/opengl-8080/items/b613b9b3bc5d796c840c
   * @link java - NoClassDefFoundError of com/fasterxml/jackson/databind/ObjectMapper with Maven https://stackoverflow.com/questions/43826718/noclassdeffounderror-of-com-fasterxml-jackson-databind-objectmapper-with-maven
   */
  protected void doRun(String[] args) {

    ResponseHttpbinGet responseHttpbinGet = this.apiClient.getInfo(title);
    ResponseHttpbinPost responseHttpbinPost = this.apiClient.postInfo(title);

    this.systemOutPrintln();
    this.systemOutPrintln("[Info]");
    this.systemOutPrintln("  " + this.getInfo().getUser());
    this.systemOutPrintln("  " + this.getInfo().getHost());
    this.systemOutPrintln("  " + this.getInfo().getPath());
    this.systemOutPrintln("  " + this.getInfo().getTimeStartStr());
    this.systemOutPrintln("  " + this.getInfo().getTimeCurrentStr());
    this.systemOutPrintln("  " + this.getInfo().getTimeDurationSec());
    this.systemOutPrintln();
    this.systemOutPrintln("[Result <GET>]");
    this.systemOutPrintln("  Input title : " + title);
    this.systemOutPrintln("  httpbin/get : ");
    this.systemOutPrintln("    args : ");
    responseHttpbinGet.args.forEach((k, v) -> this.systemOutPrintln("      " + k + " : " + v));
    this.systemOutPrintln("    headers : ");
    responseHttpbinGet.headers.forEach((k, v) -> this.systemOutPrintln("      " + k + " : " + v));
    this.systemOutPrintln("    origin :  " + responseHttpbinGet.origin);
    this.systemOutPrintln("    url    :  " + responseHttpbinGet.url);
    this.systemOutPrintln();
    this.systemOutPrintln("[Result <POST>]");
    this.systemOutPrintln("  httpbin/post : ");
    this.systemOutPrintln("    form : ");
    responseHttpbinPost.form.forEach((k, v) -> this.systemOutPrintln("      " + k + " : " + v));
    this.systemOutPrintln("    headers : ");
    responseHttpbinPost.headers.forEach((k, v) -> this.systemOutPrintln("      " + k + " : " + v));
    this.systemOutPrintln("    origin :  " + responseHttpbinPost.origin);
    this.systemOutPrintln("    url    :  " + responseHttpbinPost.url);
    this.systemOutPrintln();
  }
}
