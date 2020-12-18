package com.example.demojdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoJdbctemplateApplication implements CommandLineRunner {

	@Autowired
	private FruitDao fruitDao;
	public static void main(String[] args) {
		SpringApplication.run(DemoJdbctemplateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		fruitDao.insertData();
		fruitDao.selectData();
	}
}
