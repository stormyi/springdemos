package com.example.demotransaction;

import org.springframework.transaction.annotation.Transactional;

public interface FunctionInterface {
    void execute();
    void executeThenException() throws RollbackException;
    void invokeExecuteTheException();
}
