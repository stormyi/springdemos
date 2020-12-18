package com.example.demotransaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class FruitService implements FunctionInterface{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void execute() {

    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void executeThenException() {
        jdbcTemplate.update("insert into fruit(name) value(?)", "BBB");
        log.info("BBB有{}条", jdbcTemplate.queryForObject("select count(*) from fruit name='BBB'", Integer.class));
        throw new RuntimeException();
    }

    @Override
    public void invokeExecuteTheException() {
    }

}
