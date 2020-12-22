package com.example.demomybatis.handler;

import lombok.val;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class MyDateTypeHandler extends BaseTypeHandler<Date> {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, dateFormat.format(date));
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return resultSet.wasNull() ? null : strToDate(resultSet.getString(s));
    }

    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.wasNull() ? null : strToDate(resultSet.getString(i));
    }

    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.wasNull() ? null : strToDate(callableStatement.getString(i));
    }

    /**
     * 字符串转换为Date.
     */
    private Date strToDate(String str) {
        try {
            return str == null ? null : dateFormat.parse(str);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Cannot convert [" + str + "] to java.util.Date", e);
        }
    }
}