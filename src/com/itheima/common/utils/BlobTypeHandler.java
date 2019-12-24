package com.itheima.common.utils;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;

public class BlobTypeHandler extends BaseTypeHandler {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Blob blob = resultSet.getBlob(s);
        return new String(blob.getBytes(1, (int)blob.length()));
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        Blob blob = resultSet.getBlob(i);
        return new String(blob.getBytes(1, (int)blob.length()));
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        Blob blob = callableStatement.getBlob(i);
        return new String(blob.getBytes(1, (int)blob.length()));
    }
}
