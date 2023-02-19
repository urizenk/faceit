package com.kot.boot.dao.mongo;

import com.kot.boot.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author yf
 * @create 2022-12-18 22:04
 */
public interface BookDaoTypeOne extends MongoRepository<Book, String> {
}
