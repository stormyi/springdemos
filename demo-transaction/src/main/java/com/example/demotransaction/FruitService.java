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
    public void executeThenException() throws NotRollbackException {
        jdbcTemplate.update("insert into fruit(name) value(?)", "BBB");
        // 这里少了一个where，居然不报错？？
//        log.info("BBB有{}条", jdbcTemplate.queryForObject("select count(*) from fruit name='BBB'", Integer.class));
        log.info("BBB有{}条", jdbcTemplate.queryForObject("select count(*) from fruit where name='BBB'", Integer.class));
        throw new NotRollbackException();
    }

    @Override
    public void invokeExecuteTheException() {
    }

}
