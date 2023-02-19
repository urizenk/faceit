package com.kot.mybatis.mapper;

import com.kot.mybatis.pojo.Amount;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author yf
 * @create 2022-12-12 21:08
 */
public interface AmountMapper {
    int insertAmount();

    int updateAmount();

    int deleteAmount();

    Amount getAmountByid();

    List<Amount> getAllAmount();

    Amount getAmountByname( @Param("username") String name);

    int getCount();

    Map<Integer,Amount> getAmountByIdToMap(@Param("id") Integer id);

    @MapKey("id")
    Map<String,Object> getAllAmountToMap();

    int deleteMore(String ids);
}
