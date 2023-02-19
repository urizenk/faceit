package com.kot.boot.test;

/**
 * @author yf
 * @create 2022-12-18 22:06
 */

import com.kot.boot.dao.mongo.BookDaoTypeOne;
import com.kot.boot.domain.Book;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class MongoTest {

    @Autowired
    private BookDaoTypeOne daoTypeOne;

    @Test
    public void testAddOne(){
        for (int i = 0; i < 10; i++) {
            Book book = new Book()
                    .setId(i)
                    .setName("龙族"+i)
                    .setAuther("江南")
                    .setPrice(20+i)
                    .setPublishTime(new Date(System.currentTimeMillis()));

            daoTypeOne.save(book);
        }
    }
    
    @Test
    public void testDeleteOneById(){
        daoTypeOne.deleteById("5");
    }
    
    @Test
    public void testDeleteOneByName(){
        daoTypeOne.deleteAll();
    }


}
