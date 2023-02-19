package com.kot.jdbc.crud;

import com.kot.jdbc.utils.ConnectionUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author yf
 * @create 2022-12-11 16:03
 */
public class BatchInsert {

    @Test
    public void test() throws Exception{
        Connection connection = ConnectionUtils.getConnection();
        String sql = "insert into goods(name) values (?)";
        connection.setAutoCommit(false);
        PreparedStatement ps = connection.prepareStatement(sql);
        for (int i = 0; i <= 10000; i++) {
            ps.setString(1,"name_" + i);
            ps.addBatch();
            if(i % 500 == 0){
                ps.executeBatch();
                ps.clearBatch();
            }
        }
        connection.commit();
        ConnectionUtils.closeResource(connection,ps);
    }

}
