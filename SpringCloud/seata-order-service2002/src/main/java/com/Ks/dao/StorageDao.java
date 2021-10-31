package com.Ks.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Classname StorageDao
 * @Date 2021/10/31 15:41
 * @Created Ks
 */
@Mapper
public interface StorageDao {
    /**
     * 扣减库存信息
     * @param productId
     * @param count
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
