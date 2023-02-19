package com.kot.mybatis.test;

import com.kot.mybatis.mapper.AmountMapper;
import com.kot.mybatis.pojo.Amount;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author yf
 * @create 2022-12-12 21:23
 */
public class MybatisTest {
    @Test
    public void testMybatis() throws Exception{
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(resourceAsStream);
        SqlSession session = factory.openSession();
        AmountMapper mapper = session.getMapper(AmountMapper.class);

//        mapper.deleteAmount();
//        Amount amount = mapper.getAmountByid();
//        System.out.println(amount.toString());
//        List<Amount> allAmount = mapper.getAllAmount();
//        allAmount.forEach(amount -> System.out.println(amount));
//        Amount amount = mapper.getAmountByname("张楚");
//        System.out.println(mapper.getCount());
//        Map<Integer, Amount> amountByIdToMap = mapper.getAmountByIdToMap(4);
//        System.out.println(amountByIdToMap);


        mapper.deleteMore("1,2,3");

        session.commit();


    }
}
