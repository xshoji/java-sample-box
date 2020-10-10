package com.xshoji.guicewebapicommandset.entity;

import java.io.Serializable;

/**
 * Created by shojinao on 2017/05/09.
 */
public class Person implements Serializable {
  private Integer id;

  private String name;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
