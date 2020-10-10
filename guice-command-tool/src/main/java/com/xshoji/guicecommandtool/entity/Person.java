package com.xshoji.guicecommandtool.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by shojinao on 2017/06/11.
 */
@Entity
@Table(name = "PERSON")
public class Person {

  @Id
  //@GeneratedValue(strategy= GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String nickName;

  /**
   * Set id
   *
   * @param id
   * @return this
   */
  public Person setId(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   *
   * @return Long
   */
  public Long getId() {
    return this.id;
  }


  /**
   * Set name
   *
   * @param name
   * @return this
   */
  public Person setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   *
   * @return String
   */
  public String getName() {
    return this.name;
  }

  /**
   * Set nickName
   *
   * @param nickName
   * @return this
   */
  public Person setNickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  /**
   * Get nickName
   *
   * @return String
   */
  public String getNickName() {
    return this.nickName;
  }
}
