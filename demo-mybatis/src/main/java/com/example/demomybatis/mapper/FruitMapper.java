package com.example.demomybatis.mapper;

import com.example.demomybatis.model.Fruit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FruitMapper {
   @Insert("insert into fruits(name, class, count, date) values(#{name}, #{_class}, #{count}, #{date})")
   @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
   int save(Fruit fruit);

   @Select("select * from fruits where id = #{value}")
   Fruit findById(int id);
}
