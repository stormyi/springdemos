package com.example.demomuldatasource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class DemoMulDatasourceApplication implements CommandLineRunner {
	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(DemoMulDatasourceApplication.class, args);
	}

	@Override
	public void run(String... args) throws SQLException {
		showSingleConnection();
	}

	private void showSingleConnection() throws SQLException {
		log.info(dataSource.toString());
		Connection conn= dataSource.getConnection();
		log.info(conn.toString());
		conn.close();
	}

}
