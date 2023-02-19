package com.kot.jdbc.crud;

import com.kot.jdbc.pojo.Amount;
import com.kot.jdbc.pojo.Photo;
import com.kot.jdbc.pojo.UserInfo;
import com.kot.jdbc.utils.ConnectionUtils;
import org.junit.Test;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yf
 * @create 2022-12-10 17:01
 */
public class Query {
    @Test
    public void testQuery1() throws SQLException {
        Connection connection = ConnectionUtils.getConnection();
        String sql = "select nick_name,level,job,register_time from user_info ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            String nickName = resultSet.getString(1);
            int level = resultSet.getInt(2);
            String job = resultSet.getString(3);
            Timestamp timestamp = resultSet.getTimestamp(4);
            UserInfo userInfo = new UserInfo();
            userInfo.setNickname(nickName);
            userInfo.setLevel(level);
            userInfo.setJob(job);
            userInfo.setRegisterTime(timestamp);

            System.out.println(userInfo.toString());
        }
        ConnectionUtils.closeResource(connection,ps);
    }

    /**
     * 针对特定表的查询
     * @param sql 传入的sql
     * @param args 占位符
     * @return 用实体类映射的字段
     * @throws Exception 通用的异常
     */
    public UserInfo queryForUserInfo(String sql, Object... args) throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i+1,args[i]);
        }
        ResultSet resultSet = ps.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int count = metaData.getColumnCount();

        if(resultSet.next()){
            UserInfo userInfo = new UserInfo();
            for (int i = 0; i < count; i++) {
                Object value = resultSet.getObject(i + 1);
                String label = metaData.getColumnLabel(i + 1);
                Field field = UserInfo.class.getDeclaredField(label);
                System.out.println(field);
                System.out.println(value.toString());
                field.setAccessible(true);
                field.set(userInfo,value);
            }
            return userInfo;
        }
        return null;
    }

    /**
     * 针对不特定表的查询
     * @param clazz 传入的类
     * @param sql 传入的sql
     * @param args 占位符
     * @param <T> 具体的类型
     * @return 返回这个传入的类型
     * @throws Exception 通用的异常
     */
    public <T> T queryForTable( Class<T> clazz, String sql, Object... args)throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i+1,args[i]);
        }
        ResultSet resultSet = ps.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int count = metaData.getColumnCount();

        if(resultSet.next()){
            T t = clazz.newInstance();
            for (int i = 0; i < count; i++) {
                Object value = resultSet.getObject(i + 1);
                String label = metaData.getColumnLabel(i + 1);
                Field field = clazz.getDeclaredField(label);
                field.setAccessible(true);
                field.set(t,value);
            }
            return t;
        }
        return null;
    }


    public <T> List<T> getForList(Class<T> clazz, String sql, Object... args)throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            ps.setObject(i+1,args[i]);
        }
        ResultSet resultSet = ps.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int count = metaData.getColumnCount();

        ArrayList<T> list = new ArrayList<>();
        while(resultSet.next()){
            T t = clazz.newInstance();
            for (int i = 0; i < count; i++) {
                Object value = resultSet.getObject(i + 1);
                String label = metaData.getColumnLabel(i + 1);
                Field field = clazz.getDeclaredField(label);
                field.setAccessible(true);
                field.set(t,value);

            }
            list.add(t);
        }
        return list;
    }




    @Test
    public void testGenrickDTable() throws Exception {
        String sql = "select nick_name nickName, register_time registerTime from user_info where id = ?";
        UserInfo userInfo = queryForUserInfo(sql,3);
        System.out.println(userInfo.toString());
    }


    @Test
    public void testGenerickTable() throws Exception{
        String sql1 = "select id,name,remain from amount where id = ?";
        String sql2 = "select uid,level,job from user_info where id = ?";
        Amount amount = queryForTable(Amount.class, sql1, 3);
        System.out.println(amount.toString());
        UserInfo userInfo = queryForTable(UserInfo.class, sql2, 4);
        System.out.println(userInfo.toString());
    }

    @Test
    public void testList() throws  Exception{
        String sql = "select id,name,payed,remain from amount";
        List<Amount> list = getForList(Amount.class, sql);
        System.out.println(list.toString());
    }

    @Test
    public void testBlob() throws Exception{
        String sql = "select id,photo_name photoName,photo photoBytes from photo where id = ?";
        Photo photo = queryForTable(Photo.class, sql, 1);
        FileOutputStream fileOutputStream = new FileOutputStream("宇宙飞船.jpg");
        fileOutputStream.write(photo.getPhotoBytes());
    }

}
