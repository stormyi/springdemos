package com.example.demotransaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@Slf4j
public class DemoTransactionApplication implements CommandLineRunner {
	@Autowired
    private FunctionInterface fruitService;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DemoTransactionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			fruitService.executeThenException();
		} catch (Exception e) {
			log.info("BBB有{}条", jdbcTemplate.queryForObject("select count(*) from fruit where name='BBB'", Integer.class));
		}

		try{
			fruitService.invokeExecuteTheException();
		} catch (Exception e) {
			log.info("BBB有{}条", jdbcTemplate.queryForObject("select count(*) from fruit where name='BBB'", Integer.class));
		}
	}
}
