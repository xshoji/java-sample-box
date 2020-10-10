package com.xshoji.guicewebapicommandset.repository.mapper;

import com.xshoji.guicewebapicommandset.entity.Person;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {

  @Select("SELECT * from person WHERE id = #{id}")
  Person findOne(@Param("id") Integer id);


  @Insert("INSERT into person(id, name) VALUES(#{id}, #{name})")
  void add(Person person);

  @Delete("DELETE FROM person WHERE id = #{id}")
  void remove(@Param("id") Integer id);

}
