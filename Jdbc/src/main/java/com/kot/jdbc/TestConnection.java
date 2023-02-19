package com.kot.jdbc;

import com.kot.jdbc.utils.ConnectionUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author yf
 * @create 2022-12-09 19:14
 */
public class TestConnection {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            connection = ConnectionUtils.getConnection();
        } finally {
            connection.close();
        }


    }
}
