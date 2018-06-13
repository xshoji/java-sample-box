package jp.gr.javaconf.org.nsgeorge.guicecommandtool.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;

/**
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ResponseHttpbinPost {
    public HashMap<String, String> headers;
    public HashMap<String, String> form;
    public String origin;
    public String url;
}
