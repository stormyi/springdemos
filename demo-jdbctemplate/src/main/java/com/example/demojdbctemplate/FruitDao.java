package com.example.demojdbctemplate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

@Slf4j
@Repository
public class FruitDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insertData() {
        return Stream.of("b", "c").mapToInt(bar -> jdbcTemplate.update("insert fruit(name) value(?)", bar)).sum();
    }

    public void selectData() {
        log.info("共有{}条数据，分别是：", jdbcTemplate.queryForObject("select count(*) from fruit", Long.class));
        // jdbcTemplate.queryForList("select name from fruit", String.class).forEach(name -> log.info(name));
        jdbcTemplate.queryForList("select name from fruit", String.class).forEach(log::info);
        log.info("----以下为详情-----");
        // jdbcTemplate.query("select * from fruit", new RowMapper<Fruit>() {...
        jdbcTemplate.query("select * from fruit", (resultSet, i) -> Fruit.builder()
                .id(resultSet.getInt(1))
                .name(resultSet.getString(2))
                .classZ(resultSet.getString(3))
                .count(resultSet.getInt(4))
                .date(resultSet.getString(5))
                .build()).forEach(f -> log.info("{}",f.toString()));
    }
}
