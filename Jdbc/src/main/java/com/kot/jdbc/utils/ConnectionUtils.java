package com.kot.jdbc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author yf
 * @create 2022-12-10 16:52
 */
public class ConnectionUtils {


    public static Connection getConnection(){
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mysql.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //注意顺序不能反
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    public static void closeResource(Connection conn, PreparedStatement ps){
        try {
            conn.close();
            ps.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
