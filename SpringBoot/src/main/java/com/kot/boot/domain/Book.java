package com.kot.boot.domain;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author yf
 * @create 2022-12-18 22:00
 */
@Data
@Accessors(chain = true)
public class Book {
    private int id;
    private String name;
    private String auther;
    private int price;
    private Date publishTime;
}
