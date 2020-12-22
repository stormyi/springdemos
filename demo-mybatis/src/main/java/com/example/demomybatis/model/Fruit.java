package com.example.demomybatis.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Fruit {
    private int id;
    // 名称
    private String name;
    // 种类
    private String _class;
    // 数量
    private int count;
    // 日期
    private Date date;
}
