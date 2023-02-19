package com.kot.jdbc.crud;

import com.kot.jdbc.utils.ConnectionUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yf
 * @create 2022-12-10 17:01
 */
public class Update {

    @Test
    public void testInsert() throws SQLException {
        Connection connection = ConnectionUtils.getConnection();
        String sql = "insert into user_info values (?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,7);
            ps.setInt(2,1007);
            ps.setString(3,"牛客1007号");
            ps.setInt(4,3500);
            ps.setInt(5,4);
            ps.setString(6,"Java");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date registerTime = format.parse("2021-05-20");
            ps.setDate(7,new java.sql.Date(registerTime.getTime()));
            ps.execute();
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }finally {
            ps.close();
            connection.close();
        }


    }
    @Test
    public void testUpdate() throws SQLException {
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement ps = null;
        String sql = "update class set name = ? where id = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1,"生物");
            ps.setInt(2,6);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ps.close();
            connection.close();
        }
    }

    @Test
    public void testDelete() throws SQLException {
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement ps = null;
        String sql = "delete from class where id = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,10);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ps.close();
            connection.close();
        }
    }

    /**
     * 通用的增删改方法
     * @param sql 需要传入的sql语句
     * @param args 需要填充的占位符
     */
    public void update(String sql, Object... args) throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i+1,args[i]);
        }
        ps.execute();

        ConnectionUtils.closeResource(connection,ps);
    }

    @Test
    public void testGeneric() throws Exception {
        String sql = "update student set name = ? ,class_id = ? where id = ?";
        update(sql,"kobe",3,6);
    }

    @Test
    public void testBlob() throws Exception{
        String sql = "insert into photo values(?,?,?)";
        FileInputStream is = new FileInputStream(new File("src/main/resources/spacecraft.jpg"));
        update(sql,1,"宇宙飞船",is);
    }

}
