package com.example.demomybatis;

import com.example.demomybatis.mapper.FruitMapper;
import com.example.demomybatis.model.Fruit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@Slf4j
public class DemoMybatisApplication implements CommandLineRunner {

    @Autowired
    private FruitMapper fruitMapper;

    public static void main(String[] args) {
        SpringApplication.run(DemoMybatisApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Fruit fruit = Fruit.builder().name("test")._class("字段映射测试").count(0).date(new Date()).build();
        int num = fruitMapper.save(fruit);
        log.info("Save {} {}", fruit, num == 1 ? "SUCCESS" : "FAILD");
        fruit = fruitMapper.findById(fruit.getId());
        log.info(fruit.toString());
    }
}
