package com.example.demojdbctemplate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fruit {
    private int id;
    private String name;
    private String classZ;
    private int count;
    private String date;
}
