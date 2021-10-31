package com.Ks.dao;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

/**
 * @Classname AccountDao
 * @Date 2021/10/31 15:47
 * @Created Ks
 */
@Mapper
public interface AccountDao {
    void decrease(Long userId, BigDecimal money);
}
