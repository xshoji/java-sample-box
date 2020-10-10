package com.xshoji.guicecommandtool.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;

/**
 * @link Jackson - 新ねこら対策秘密力要塞基地日誌 http://nekora.hatenablog.com/entry/20150219/p1
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseHttpbinGet {
  public HashMap<String, String> args;
  public HashMap<String, String> headers;
  public String origin;
  public String url;
}
